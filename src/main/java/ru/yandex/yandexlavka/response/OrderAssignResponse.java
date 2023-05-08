package ru.yandex.yandexlavka.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.yandex.yandexlavka.dto.courier.CouriersGroupOrders;

import java.util.List;

@Data
public class OrderAssignResponse {
    @JsonProperty("date")
    private String date;
    @JsonProperty("couriers")
    private List<CouriersGroupOrders> couriers;
}
