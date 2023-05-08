package ru.yandex.yandexlavka.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.domain.order.Order;
import ru.yandex.yandexlavka.domain.order.OrderStatus;
import ru.yandex.yandexlavka.dto.order.CompleteOrder;
import ru.yandex.yandexlavka.dto.order.CreateOrderRequest;
import ru.yandex.yandexlavka.dto.order.OrderDto;
import ru.yandex.yandexlavka.exceptions.general.InvalidRequestException;
import ru.yandex.yandexlavka.exceptions.order.InvalidCompleteOrderRequestDtoException;
import ru.yandex.yandexlavka.exceptions.order.OrderNotFoundException;
import ru.yandex.yandexlavka.repository.order.OrderRepository;
import ru.yandex.yandexlavka.request.CompleteOrderRequestDto;
import ru.yandex.yandexlavka.response.OrderAssignResponse;
import ru.yandex.yandexlavka.service.mapper.order.CreateOrderDtoToOrderMapper;
import ru.yandex.yandexlavka.service.mapper.order.OrderToOrderDtoMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CreateOrderDtoToOrderMapper createOrderDtoToOrderMapper;
    private final OrderToOrderDtoMapper orderToOrderDtoMapper;

    @Override
    public List<OrderDto> createOrders(CreateOrderRequest createOrderRequest) {
        List<Order> orders = createOrderRequest.getOrders().stream()
                .map(createOrderDtoToOrderMapper::mapToDomain)
                .toList();
        List<Order> saved = orderRepository.saveAll(orders);

        return saved.stream()
                .map(orderToOrderDtoMapper::mapToDto)
                .toList();
    }

    @Override
    public List<OrderDto> getOrdersWithLimitAndOffset(int limit, int offset) {
        return orderRepository.findAll().stream()
                .skip(offset)
                .limit(limit)
                .map(orderToOrderDtoMapper::mapToDto)
                .toList();
    }

    @Override
    public OrderDto getOrderByIdOrThrow(long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
        return orderToOrderDtoMapper.mapToDto(order);
    }

    @Override
    public List<OrderDto> completeOrders(CompleteOrderRequestDto completeOrderRequestDto) {
        List<Order> completedOrders = new ArrayList<>();
        for (CompleteOrder completeOrder : completeOrderRequestDto.getCompleteInfo()) {
            Order complete = orderRepository
                    .findById(completeOrder.getOrderId())
                    .orElseThrow(InvalidCompleteOrderRequestDtoException::new);
            if (completeOrderPredicate(complete, completeOrder)) {
                throw new InvalidCompleteOrderRequestDtoException();
            }
            complete.setCompleteTime(LocalDateTime.parse(completeOrder.getCompleteTime()));
            completedOrders.add(complete);
        }
        orderRepository.saveAll(completedOrders);
        return completedOrders.stream().map(orderToOrderDtoMapper::mapToDto).toList();
    }

    private boolean completeOrderPredicate(Order order, CompleteOrder completeOrder) {
        return   order.getStatus() != OrderStatus.ATTACHED
                || order.getCourier().getId() != completeOrder.getCourierId();
    }

    @Override
    public List<OrderAssignResponse> assignOrdersByDate(String date) {
        return null;
    }
}
