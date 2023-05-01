package ru.yandex.yandexlavka.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateCourierDto {
    @JsonProperty("courier_type")
    private String courierType;
    @JsonProperty("regions")
    private List<Integer> regions;
    @JsonProperty("working_hours")
    private List<String> workingHours;
}
