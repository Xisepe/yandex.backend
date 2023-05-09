package ru.yandex.yandexlavka.service.validator.courier;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.yandex.yandexlavka.domain.courier.CourierType;
import ru.yandex.yandexlavka.dto.courier.CreateCourierDto;
import ru.yandex.yandexlavka.request.CreateCourierRequest;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class CreateCourierRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CreateCourierRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateCourierRequest request = (CreateCourierRequest) target;
        Set<String> possibleTypes = new HashSet<>(Arrays.stream(CourierType.values()).map(CourierType::toString).toList());
        for (CreateCourierDto courier : request.getCouriers()) {
            if (!possibleTypes.contains(courier.getCourierType())){
                errors.reject("courierType");
                break;
            }
            if (courier.getRegions().stream().anyMatch(e->e <= 0)) {
                errors.reject("regions");
                break;
            }
            for (String workingHour : courier.getWorkingHours()) {
                if (workingHour.matches(".+-.+")) {
                    String[] split = workingHour.split("-");
                    try {
                        LocalTime.parse(split[0]);
                        LocalTime.parse(split[1]);
                    } catch (DateTimeParseException e) {
                        errors.reject("workingHours");
                    }
                } else {
                    errors.reject("time");
                    break;
                }
            }
        }
    }
}
