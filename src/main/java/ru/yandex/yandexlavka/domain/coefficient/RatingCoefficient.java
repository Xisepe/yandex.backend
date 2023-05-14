package ru.yandex.yandexlavka.domain.coefficient;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.courier.CourierType;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class RatingCoefficient {
    private final Map<CourierType, Integer> coefficients = new HashMap<>(){{
       put(CourierType.FOOT, 3);
       put(CourierType.BIKE, 2);
       put(CourierType.AUTO, 1);
    }};
}
