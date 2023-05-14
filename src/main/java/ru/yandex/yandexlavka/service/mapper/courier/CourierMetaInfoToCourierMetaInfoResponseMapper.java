package ru.yandex.yandexlavka.service.mapper.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.yandex.yandexlavka.domain.courier.CourierMetaInfo;
import ru.yandex.yandexlavka.dto.courier.CourierDto;
import ru.yandex.yandexlavka.response.GetCourierMetaInfoResponse;
import ru.yandex.yandexlavka.service.mapper.DomainToDtoMapper;
@RequiredArgsConstructor
@Component
public class CourierMetaInfoToCourierMetaInfoResponseMapper implements DomainToDtoMapper<CourierMetaInfo, GetCourierMetaInfoResponse> {
    private final CourierToCourierDtoMapper courierToCourierDtoMapper;
    @Override
    public GetCourierMetaInfoResponse mapToDto(CourierMetaInfo domain) {
        GetCourierMetaInfoResponse response = new GetCourierMetaInfoResponse();
        CourierDto courierDto = courierToCourierDtoMapper.mapToDto(domain.getCourier());
        response.setCourierId(courierDto.getId());
        response.setCourierType(courierDto.getCourierType());
        response.setRegions(courierDto.getRegions());
        response.setWorkingHours(courierDto.getWorkingHours());
        response.setRating(domain.getRating());
        response.setEarnings(domain.getEarnings());
        return response;
    }
}
