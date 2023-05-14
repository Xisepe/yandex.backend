package ru.yandex.yandexlavka.domain.coefficient;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.courier.CourierType;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class EarningCoefficient {
    private final Map<CourierType, Integer> coefficients = new HashMap<>(){{
        put(CourierType.FOOT, 2);
        put(CourierType.BIKE, 3);
        put(CourierType.AUTO, 4);
    }};
}
