package ru.yandex.yandexlavka.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompleteOrder {
    @JsonProperty(value = "courier_id", required = true)
    private long courierId;

    @JsonProperty(value = "order_id", required = true)
    private long orderId;

    @JsonProperty(value = "complete_time",required = true)
    private LocalDateTime completeTime;
}
