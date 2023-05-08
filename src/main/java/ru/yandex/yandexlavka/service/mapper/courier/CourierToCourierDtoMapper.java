package ru.yandex.yandexlavka.service.mapper.courier;

import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.courier.Courier;
import ru.yandex.yandexlavka.domain.courier.CourierRegion;
import ru.yandex.yandexlavka.dto.courier.CourierDto;
import ru.yandex.yandexlavka.service.mapper.DomainToDtoMapper;

import java.time.format.DateTimeFormatter;
@Component
public class CourierToCourierDtoMapper implements DomainToDtoMapper<Courier, CourierDto> {
    @Override
    public CourierDto mapToDto(Courier domain) {
        String dateTimePattern = "HH:MM";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);
        CourierDto dto = new CourierDto();
        dto.setCourierType(domain.getType().toString());
        dto.setId(domain.getId());
        dto.setRegions(
                domain
                        .getRegion()
                        .stream()
                        .map(CourierRegion::getRegion)
                        .toList()
        );
        dto.setWorkingHours(
                domain
                        .getWorkingHour()
                        .stream()
                        .map(e -> String.format("%s-%s", e.getStart().format(formatter), e.getEnd().format(formatter)))
                        .toList()
        );
        return dto;
    }
}
