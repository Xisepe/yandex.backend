package ru.yandex.yandexlavka.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GroupOrders {
    @JsonProperty("group_order_id")
    private long id;
    @JsonProperty("orders")
    private List<OrderDto> orders;
}
