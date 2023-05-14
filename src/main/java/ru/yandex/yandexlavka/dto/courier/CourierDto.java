package ru.yandex.yandexlavka.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class CourierDto {
    @JsonProperty(value = "courier_id", required = true)
    private Long id;

    @JsonProperty(value = "courier_type", required = true)
    @Pattern(regexp = "^(FOOT|BIKE|AUTO)$")
    private String courierType;

    @JsonProperty(value = "regions", required = true)
    @Valid
    private List<@Positive Integer> regions;

    @JsonProperty(value = "working_hours", required = true)
    @Valid
    private List<@Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]-(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") String> workingHours;
}
