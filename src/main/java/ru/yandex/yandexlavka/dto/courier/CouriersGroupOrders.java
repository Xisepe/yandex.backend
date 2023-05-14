package ru.yandex.yandexlavka.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;
import ru.yandex.yandexlavka.dto.order.GroupOrders;

import java.util.List;

@Data
public class CouriersGroupOrders {
    @JsonProperty(value = "courier_id", required = true)
    private long courierId;

    @JsonProperty(value = "orders", required = true)
    @Valid
    private List<GroupOrders> orders;
}
