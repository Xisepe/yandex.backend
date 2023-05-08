package ru.yandex.yandexlavka.service.mapper.courier;

import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.courier.Courier;
import ru.yandex.yandexlavka.domain.courier.CourierRegion;
import ru.yandex.yandexlavka.domain.courier.CourierType;
import ru.yandex.yandexlavka.domain.courier.WorkingHour;
import ru.yandex.yandexlavka.dto.courier.CreateCourierDto;
import ru.yandex.yandexlavka.service.mapper.DtoToDomainMapper;

import java.time.LocalTime;
@Component
public class CreateCourierDtoToCourierMapper implements DtoToDomainMapper<CreateCourierDto, Courier> {
    @Override
    public Courier mapToDomain(CreateCourierDto dto) {
        Courier courier = new Courier();
        courier.setWorkingHour(
                dto.getWorkingHours().stream()
                        .map(e -> {
                            String[] split = e.split("-");
                            WorkingHour workingHour = new WorkingHour();
                            LocalTime start = LocalTime.parse(split[0]);
                            LocalTime end = LocalTime.parse(split[1]);
                            workingHour.setStart(start);
                            workingHour.setEnd(end);
                            workingHour.setCourier(courier);
                            return workingHour;
                        })
                        .toList()
        );
        courier.setType(CourierType.valueOf(dto.getCourierType()));
        courier.setRegion(
                dto.getRegions().stream()
                        .map(e->{
                            CourierRegion region = new CourierRegion();
                            region.setCourier(courier);
                            region.setRegion(e);
                            return region;
                        })
                        .toList()
        );
        return courier;
    }
}
