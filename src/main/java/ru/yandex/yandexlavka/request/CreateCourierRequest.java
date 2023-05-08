package ru.yandex.yandexlavka.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.yandex.yandexlavka.dto.courier.CreateCourierDto;

import java.util.List;

@Data
public class CreateCourierRequest {
    @JsonProperty("couriers")
    private List<CreateCourierDto> couriers;
}
