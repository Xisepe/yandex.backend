package ru.yandex.yandexlavka.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.yandexlavka.domain.order.Order;
import ru.yandex.yandexlavka.dto.order.CreateOrderRequest;
import ru.yandex.yandexlavka.dto.order.OrderDto;
import ru.yandex.yandexlavka.repository.order.OrderRepository;
import ru.yandex.yandexlavka.request.CompleteOrderRequestDto;
import ru.yandex.yandexlavka.response.OrderAssignResponse;
import ru.yandex.yandexlavka.service.mapper.order.CreateOrderDtoToOrderMapper;
import ru.yandex.yandexlavka.service.mapper.order.OrderToOrderDtoMapper;

import java.util.List;

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
        return null;
    }

    @Override
    public OrderDto getOrderByIdOrThrow(long orderId) {
        return null;
    }

    @Override
    public List<OrderDto> completeOrders(CompleteOrderRequestDto completeOrderRequestDto) {
        return null;
    }

    @Override
    public List<OrderAssignResponse> assignOrdersByDate(String date) {
        return null;
    }
}
