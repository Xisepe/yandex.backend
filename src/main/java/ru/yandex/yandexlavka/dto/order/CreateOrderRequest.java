package ru.yandex.yandexlavka.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    @JsonProperty("orders")
    private List<CreateOrderDto> orders;
}
