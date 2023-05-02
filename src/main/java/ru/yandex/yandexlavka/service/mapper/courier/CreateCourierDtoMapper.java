package ru.yandex.yandexlavka.service.mapper.courier;

import ru.yandex.yandexlavka.domain.courier.Courier;
import ru.yandex.yandexlavka.domain.courier.CourierType;
import ru.yandex.yandexlavka.domain.courier.WorkingHour;
import ru.yandex.yandexlavka.dto.courier.CreateCourierDto;
import ru.yandex.yandexlavka.service.mapper.DtoToDomainMapper;

import java.time.LocalTime;

public class CreateCourierDtoMapper implements DtoToDomainMapper<CreateCourierDto, Courier> {
    @Override
    public Courier mapToDomain(CreateCourierDto dto) {
        Courier courier = new Courier();
        courier.setType(CourierType.valueOf(dto.getCourierType()));
        courier.setRegion(dto.getRegions());
        courier.setWorkingHour(
                dto.getWorkingHours()
                        .stream()
                        .map(s -> {
                                    String[] hours = s.split("-");
                                    LocalTime start = LocalTime.parse(hours[0]);
                                    LocalTime end = LocalTime.parse(hours[1]);
                                    WorkingHour workingHour = new WorkingHour();
                                    workingHour.setStart(start);
                                    workingHour.setEnd(end);
                                    return workingHour;
                                }
                        ).toList());
        return courier;
    }
}
