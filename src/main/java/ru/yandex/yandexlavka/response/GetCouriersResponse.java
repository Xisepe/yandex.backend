package ru.yandex.yandexlavka.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.yandex.yandexlavka.dto.courier.CourierDto;

import java.util.List;

@Data
public class GetCouriersResponse {
    @JsonProperty(value = "couriers", required = true)
    private List<CourierDto> couriers;
    @JsonProperty(value = "limit", required = true)
    private int limit;
    @JsonProperty(value = "offset", required = true)
    private int offset;
}
