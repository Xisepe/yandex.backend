package ru.yandex.yandexlavka.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.yandex.yandexlavka.dto.courier.CourierDto;

import java.util.List;

@Data
public class CreateCourierResponse {
    @JsonProperty(value = "couriers", required = true)
    private List<CourierDto> couriers;
}
