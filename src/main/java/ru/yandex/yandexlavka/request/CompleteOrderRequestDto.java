package ru.yandex.yandexlavka.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.yandex.yandexlavka.dto.order.CompleteOrder;

import java.util.List;

@Data
public class CompleteOrderRequestDto {
    @JsonProperty("complete_info")
    private List<CompleteOrder> completeInfo;
}
