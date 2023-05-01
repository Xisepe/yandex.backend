package ru.yandex.yandexlavka.service.mapper.courier;

import ru.yandex.yandexlavka.domain.courier.Courier;
import ru.yandex.yandexlavka.domain.courier.CourierType;
import ru.yandex.yandexlavka.dto.courier.CourierDto;
import ru.yandex.yandexlavka.dto.courier.CreateCourierDto;
import ru.yandex.yandexlavka.service.mapper.DtoToDomainMapper;

public class CreateCourierDtoMapper implements DtoToDomainMapper<CreateCourierDto, Courier> {
    @Override
    public Courier mapToDomain(CreateCourierDto dto) {
        Courier courier = new Courier();
        courier.setType(CourierType.valueOf(dto.getCourierType()));
        courier.setRegions(dto.getRegions());
        courier.setWorkingHours();
    }
}
