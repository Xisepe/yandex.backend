package ru.yandex.yandexlavka.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {
    @JsonProperty(value = "weight", required = true)
    @Positive
    private double weight;

    @JsonProperty(value = "regions", required = true)
    @Positive
    private int region;

    @JsonProperty(value = "delivery_hours", required = true)
    @Valid
    private List<
            @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]-(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
            String
            > deliveryHours;

    @JsonProperty(value = "cost", required = true)
    @Positive
    private int cost;
}
