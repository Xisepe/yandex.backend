package ru.yandex.yandexlavka.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class GroupOrders {
    @JsonProperty(value = "group_order_id", required = true)
    private long id;

    @JsonProperty(value = "orders", required = true)
    @Valid
    private List<OrderDto> orders;
}
