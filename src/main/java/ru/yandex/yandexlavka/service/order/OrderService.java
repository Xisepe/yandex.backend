package ru.yandex.yandexlavka.service.order;

import ru.yandex.yandexlavka.dto.order.CreateOrderRequest;
import ru.yandex.yandexlavka.dto.order.OrderDto;
import ru.yandex.yandexlavka.request.CompleteOrderRequestDto;
import ru.yandex.yandexlavka.response.OrderAssignResponse;

import java.util.List;

public interface OrderService {
    List<OrderDto> createOrders(CreateOrderRequest createOrderRequest);
    List<OrderDto> getOrdersWithLimitAndOffset(int limit, int offset);
    OrderDto getOrderByIdOrThrow(long orderId);
    List<OrderDto> completeOrders(CompleteOrderRequestDto completeOrderRequestDto);
    List<OrderAssignResponse> assignOrdersByDate(String date);
}
