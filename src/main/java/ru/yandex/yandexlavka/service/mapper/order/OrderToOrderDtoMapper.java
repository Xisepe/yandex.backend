package ru.yandex.yandexlavka.service.mapper.order;

import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.order.DeliveryHour;
import ru.yandex.yandexlavka.domain.order.Order;
import ru.yandex.yandexlavka.dto.order.OrderDto;
import ru.yandex.yandexlavka.service.mapper.DomainToDtoMapper;
@Component
public class OrderToOrderDtoMapper implements DomainToDtoMapper<Order, OrderDto> {
    @Override
    public OrderDto mapToDto(Order domain) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(domain.getId());
        orderDto.setCost(domain.getCost());
        orderDto.setWeight(domain.getWeight());
        orderDto.setRegion(domain.getRegion());
        orderDto.setDeliveryHours(
                domain.getDeliveryHours().stream()
                        .map(this::mapDeliveryHourToString)
                        .toList()
        );
        if (domain.getCompleteTime() != null) {
            orderDto.setCompletedTime(domain.getCompleteTime().toString());
        }
        return orderDto;
    }
    private String mapDeliveryHourToString(DeliveryHour deliveryHour) {
        return String.format("%s-%s",deliveryHour.getStart().toString(), deliveryHour.getEnd().toString());
    }
}
