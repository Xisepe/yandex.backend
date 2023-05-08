package ru.yandex.yandexlavka.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.yandex.yandexlavka.dto.order.GroupOrders;

import java.util.List;

@Data
public class CouriersGroupOrders {
    @JsonProperty("courier_id")
    private long courierId;
    @JsonProperty("orders")
    private List<GroupOrders> orders;
}
