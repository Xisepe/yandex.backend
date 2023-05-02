package ru.yandex.yandexlavka.request;

import lombok.Data;
import ru.yandex.yandexlavka.dto.courier.CreateCourierDto;

import java.util.List;

@Data
public class CreateCourierRequest {
    private List<CreateCourierDto> couriers;
}
