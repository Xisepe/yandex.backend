package ru.yandex.yandexlavka.domain.courier;

import lombok.Data;

@Data
public class CourierMetaInfo {
    private final Courier courier;
    private final Integer earnings;
    private final Integer rating;
}
