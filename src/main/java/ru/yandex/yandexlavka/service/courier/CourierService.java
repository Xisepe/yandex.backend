package ru.yandex.yandexlavka.service.courier;

import ru.yandex.yandexlavka.dto.courier.CourierDto;
import ru.yandex.yandexlavka.request.CreateCourierRequest;
import ru.yandex.yandexlavka.response.CreateCourierResponse;
import ru.yandex.yandexlavka.response.GetCourierMetaInfoResponse;
import ru.yandex.yandexlavka.response.GetCouriersResponse;
import ru.yandex.yandexlavka.response.OrderAssignResponse;

public interface CourierService {
    OrderAssignResponse getCourierAssignmentByDateAndId(String date, long courierId);
    CreateCourierResponse createCouriers(CreateCourierRequest createCourierRequest);
    GetCouriersResponse getCouriersByLimitAndOffset(int limit, int offset);
    CourierDto getCourierById(long courierId);
    GetCourierMetaInfoResponse getCourierMetaInfoByIdAndStartDateAndEndDate(long courierId, String startDate, String endDate);
}
