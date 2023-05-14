package ru.yandex.yandexlavka.dto.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import ru.yandex.yandexlavka.domain.courier.CourierType;

import java.util.List;

@Data
public class CreateCourierDto {
    @JsonProperty(value = "courier_type", required = true)
    private CourierType courierType;

    @JsonProperty(value = "regions", required = true)
    @Valid
    private List<@Positive Integer> regions;

    @JsonProperty(value = "working_hours", required = true)
    @Valid
    private List<@Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]-(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") String> workingHours;
}
