package ru.yandex.yandexlavka.response;

import lombok.Data;
import ru.yandex.yandexlavka.dto.courier.CourierDto;

import java.util.List;

@Data
public class GetCouriersResponse {
    private List<CourierDto> couriers;
    private int limit;
    private int offset;
}
