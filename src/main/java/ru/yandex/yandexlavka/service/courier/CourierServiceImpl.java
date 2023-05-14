package ru.yandex.yandexlavka.service.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.domain.coefficient.EarningCoefficient;
import ru.yandex.yandexlavka.domain.coefficient.RatingCoefficient;
import ru.yandex.yandexlavka.domain.courier.Courier;
import ru.yandex.yandexlavka.domain.courier.CourierMetaInfo;
import ru.yandex.yandexlavka.domain.order.Assignment;
import ru.yandex.yandexlavka.domain.order.Order;
import ru.yandex.yandexlavka.dto.courier.CourierDto;
import ru.yandex.yandexlavka.exceptions.courier.CourierNotFoundException;
import ru.yandex.yandexlavka.repository.courier.CourierRepository;
import ru.yandex.yandexlavka.repository.order.AssignmentRepository;
import ru.yandex.yandexlavka.repository.order.OrderRepository;
import ru.yandex.yandexlavka.request.CreateCourierRequest;
import ru.yandex.yandexlavka.response.CreateCourierResponse;
import ru.yandex.yandexlavka.response.GetCourierMetaInfoResponse;
import ru.yandex.yandexlavka.response.GetCouriersResponse;
import ru.yandex.yandexlavka.response.OrderAssignResponse;
import ru.yandex.yandexlavka.service.mapper.courier.CourierMetaInfoToCourierMetaInfoResponseMapper;
import ru.yandex.yandexlavka.service.mapper.courier.CourierToCourierDtoMapper;
import ru.yandex.yandexlavka.service.mapper.courier.CreateCourierDtoToCourierMapper;
import ru.yandex.yandexlavka.service.mapper.order.AssignmentToCouriersGroupOrdersMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;
    private final OrderRepository orderRepository;
    private final AssignmentRepository assignmentRepository;
    private final CourierToCourierDtoMapper courierToCourierDtoMapper;
    private final CreateCourierDtoToCourierMapper createCourierDtoToCourierMapper;
    private final CourierMetaInfoToCourierMetaInfoResponseMapper courierMetaInfoToCourierMetaInfoResponseMapper;
    private final AssignmentToCouriersGroupOrdersMapper assignmentToCouriersGroupOrdersMapper;
    private final EarningCoefficient earningCoefficient;
    private final RatingCoefficient ratingCoefficient;

    @Override
    public OrderAssignResponse getCourierAssignmentByDateAndId(LocalDate date, Long courierId) {
        List<Assignment> assignments;

        if (courierId != null) {
            assignments = assignmentRepository.findAllByDateAndCourierId(date, courierId);
        } else {
            assignments = assignmentRepository.findAllByDate(date);
        }
        OrderAssignResponse orderAssignResponse = new OrderAssignResponse();
        orderAssignResponse.setDate(date);
        orderAssignResponse.setCouriers(
                assignments.stream()
                        .map(assignmentToCouriersGroupOrdersMapper::mapToDto)
                        .toList()
        );
        return orderAssignResponse;
    }

    @Override
    public CreateCourierResponse createCouriers(CreateCourierRequest createCourierRequest) {
        List<Courier> couriers = createCourierRequest.getCouriers().stream()
                .map(createCourierDtoToCourierMapper::mapToDomain)
                .toList();
        List<Courier> saved = courierRepository.saveAll(couriers);
        CreateCourierResponse response = new CreateCourierResponse();
        response.setCouriers(
                saved.stream()
                        .map(courierToCourierDtoMapper::mapToDto)
                        .toList()
        );
        return response;
    }

    @Override
    public GetCouriersResponse getCouriersWithLimitAndOffset(int limit, int offset) {
        List<CourierDto> courierDtoList = courierRepository
                .findAll()
                .stream()
                .skip(offset)
                .limit(limit)
                .map(courierToCourierDtoMapper::mapToDto)
                .toList();
        GetCouriersResponse response = new GetCouriersResponse();
        response.setCouriers(courierDtoList);
        response.setOffset(offset);
        response.setLimit(limit);
        return response;
    }

    @Override
    public CourierDto getCourierByIdOrThrow(long courierId) {
        Courier courier = courierRepository.findById(courierId).orElseThrow(CourierNotFoundException::new);
        return courierToCourierDtoMapper.mapToDto(courier);
    }

    @Override
    public GetCourierMetaInfoResponse getCourierMetaInfoByIdAndStartDateAndEndDate(long courierId, LocalDate startDate, LocalDate endDate) {
        LocalDateTime sd = startDate.atStartOfDay();
        LocalDateTime ed = endDate.atStartOfDay();
        List<Order> completeOrders = orderRepository
                .findAllByCourierIdAndCompleteTimeBetween(courierId, sd, ed);
        Courier courier = courierRepository.findById(courierId).orElseThrow(CourierNotFoundException::new);
        Integer earnings = null;
        Integer rating = null;
        if (!completeOrders.isEmpty()) {
            earnings = calculateEarnings(
                    completeOrders,
                    earningCoefficient.getCoefficients().get(courier.getType())
            );
            rating = calculateRating(
                    completeOrders.size(),
                    (int) sd.until(endDate, ChronoUnit.HOURS),
                    ratingCoefficient.getCoefficients().get(courier.getType())
            );
        }
        return courierMetaInfoToCourierMetaInfoResponseMapper
                .mapToDto(new CourierMetaInfo(
                        courier,
                        earnings,
                        rating
                ));
    }

    private int calculateEarnings(List<Order> completeOrders, int c) {
        return completeOrders.stream()
                .map(Order::getCost)
                .reduce(0, (acc, x) -> acc + x * c);
    }

    private int calculateRating(int number, int hours, int c) {
        return number / (hours * c);
    }
}
