package ru.yandex.yandexlavka.service.mapper.order;

import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.order.DeliveryHour;
import ru.yandex.yandexlavka.domain.order.Order;
import ru.yandex.yandexlavka.domain.order.OrderStatus;
import ru.yandex.yandexlavka.dto.order.CreateOrderDto;
import ru.yandex.yandexlavka.service.mapper.DtoToDomainMapper;

import java.time.LocalTime;
@Component
public class CreateOrderDtoToOrderMapper implements DtoToDomainMapper<CreateOrderDto, Order> {
    @Override
    public Order mapToDomain(CreateOrderDto dto) {
        Order order = new Order();
        order.setCost(dto.getCost());
        order.setRegion(dto.getRegion());
        order.setDeliveryHours(
                dto.getDeliveryHours().stream()
                        .map(e->parseDeliveryHour(e, order))
                        .toList()
        );
        order.setStatus(OrderStatus.EMPTY);
        order.setWeight(dto.getWeight());
        return order;
    }
    private DeliveryHour parseDeliveryHour(String time, Order order) {
        DeliveryHour deliveryHour = new DeliveryHour();
        String[] split = time.split("-");
        deliveryHour.setStart(LocalTime.parse(split[0]));
        deliveryHour.setFinish(LocalTime.parse(split[1]));
        return deliveryHour;
    }
}
