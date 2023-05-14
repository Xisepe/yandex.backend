package ru.yandex.yandexlavka.service.mapper.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.order.GroupedOrders;
import ru.yandex.yandexlavka.dto.order.GroupOrders;
import ru.yandex.yandexlavka.service.mapper.DomainToDtoMapper;

@Component
@RequiredArgsConstructor
public class GroupedOrdersToGroupOrdersMapper implements DomainToDtoMapper<GroupedOrders, GroupOrders> {
    private final OrderToOrderDtoMapper orderToOrderDtoMapper;
    @Override
    public GroupOrders mapToDto(GroupedOrders domain) {
        GroupOrders groupOrders = new GroupOrders();
        groupOrders.setId(domain.getId());
        groupOrders.setOrders(
                domain.getOrders().stream()
                        .map(orderToOrderDtoMapper::mapToDto)
                        .toList()
        );
        return groupOrders;
    }
}
