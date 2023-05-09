package ru.yandex.yandexlavka.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;
import ru.yandex.yandexlavka.dto.order.CompleteOrder;

import java.util.List;

@Data
public class CompleteOrderRequestDto {
    @JsonProperty("complete_info")
    @Valid
    private List<CompleteOrder> completeInfo;
}
