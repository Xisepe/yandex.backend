package ru.yandex.yandexlavka.service.mapper.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.order.Assignment;
import ru.yandex.yandexlavka.dto.courier.CouriersGroupOrders;
import ru.yandex.yandexlavka.service.mapper.DomainToDtoMapper;

@Component
@RequiredArgsConstructor
public class AssignmentToCouriersGroupOrdersMapper implements DomainToDtoMapper<Assignment, CouriersGroupOrders> {
    private final GroupedOrdersToGroupOrdersMapper groupedOrdersToGroupOrdersMapper;

    @Override
    public CouriersGroupOrders mapToDto(Assignment domain) {
        CouriersGroupOrders couriersGroupOrders = new CouriersGroupOrders();
        couriersGroupOrders.setCourierId(domain.getCourier().getId());
        couriersGroupOrders.setOrders(
                domain.getOrders().stream()
                        .map(groupedOrdersToGroupOrdersMapper::mapToDto)
                        .toList()
        );
        return couriersGroupOrders;
    }
}
