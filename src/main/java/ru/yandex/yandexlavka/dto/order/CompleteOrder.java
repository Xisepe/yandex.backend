package ru.yandex.yandexlavka.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CompleteOrder {
    @JsonProperty("courier_id")
    private long courierId;
    @JsonProperty("order_id")
    private long orderId;
    @JsonProperty("complete_time")
    private String completeTime;
}
