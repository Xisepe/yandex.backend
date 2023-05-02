package ru.yandex.yandexlavka.response;

import lombok.Data;
import ru.yandex.yandexlavka.dto.courier.CourierDto;

import java.util.List;

@Data
public class CreateCourierResponse {
    private List<CourierDto> couriers;
}
