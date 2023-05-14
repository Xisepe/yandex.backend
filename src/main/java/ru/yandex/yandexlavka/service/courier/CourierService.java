package ru.yandex.yandexlavka.service.courier;

import ru.yandex.yandexlavka.dto.courier.CourierDto;
import ru.yandex.yandexlavka.request.CreateCourierRequest;
import ru.yandex.yandexlavka.response.CreateCourierResponse;
import ru.yandex.yandexlavka.response.GetCourierMetaInfoResponse;
import ru.yandex.yandexlavka.response.GetCouriersResponse;
import ru.yandex.yandexlavka.response.OrderAssignResponse;

import java.time.LocalDate;

public interface CourierService {
    OrderAssignResponse getCourierAssignmentByDateAndId(LocalDate date, Long courierId);
    CreateCourierResponse createCouriers(CreateCourierRequest createCourierRequest);
    GetCouriersResponse getCouriersWithLimitAndOffset(int limit, int offset);
    CourierDto getCourierByIdOrThrow(long courierId);
    GetCourierMetaInfoResponse getCourierMetaInfoByIdAndStartDateAndEndDate(long courierId, LocalDate startDate, LocalDate endDate);
}
