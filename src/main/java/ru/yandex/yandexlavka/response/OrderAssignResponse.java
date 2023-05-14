package ru.yandex.yandexlavka.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.yandex.yandexlavka.dto.courier.CouriersGroupOrders;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderAssignResponse {
    @JsonProperty(value = "date", required = true)
    private LocalDate date;
    @JsonProperty(value = "couriers", required = true)
    private List<CouriersGroupOrders> couriers;
}
