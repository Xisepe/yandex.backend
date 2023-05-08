package ru.yandex.yandexlavka.service.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.domain.courier.Courier;
import ru.yandex.yandexlavka.dto.courier.CourierDto;
import ru.yandex.yandexlavka.exceptions.courier.CourierNotFoundException;
import ru.yandex.yandexlavka.repository.courier.CourierRepository;
import ru.yandex.yandexlavka.request.CreateCourierRequest;
import ru.yandex.yandexlavka.response.CreateCourierResponse;
import ru.yandex.yandexlavka.response.GetCourierMetaInfoResponse;
import ru.yandex.yandexlavka.response.GetCouriersResponse;
import ru.yandex.yandexlavka.response.OrderAssignResponse;
import ru.yandex.yandexlavka.service.mapper.courier.CourierToCourierDtoMapper;
import ru.yandex.yandexlavka.service.mapper.courier.CreateCourierDtoToCourierMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;
    private final CourierToCourierDtoMapper courierToCourierDtoMapper;
    private final CreateCourierDtoToCourierMapper createCourierDtoToCourierMapper;

    @Override
    public OrderAssignResponse getCourierAssignmentByDateAndId(String date, long courierId) {
        return null;
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
    public GetCouriersResponse getCouriersByLimitAndOffset(int limit, int offset) {
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
        Optional<Courier> courier = courierRepository.findById(courierId);
        if (courier.isEmpty()) {
            throw new CourierNotFoundException();
        }
        return courierToCourierDtoMapper.mapToDto(courier.get());
    }

    @Override
    public GetCourierMetaInfoResponse getCourierMetaInfoByIdAndStartDateAndEndDate(long courierId, String startDate, String endDate) {
        return null;
    }
}
