package ru.yandex.yandexlavka.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {
    @JsonProperty("weight")
    private double weight;
    @JsonProperty("regions")
    private int region;
    @JsonProperty("delivery_hours")
    private List<String> deliveryHours;
    @JsonProperty("cost")
    private int cost;
}
