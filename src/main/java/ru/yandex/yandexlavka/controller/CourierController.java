package ru.yandex.yandexlavka.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.dto.courier.CourierDto;
import ru.yandex.yandexlavka.request.CreateCourierRequest;
import ru.yandex.yandexlavka.response.CreateCourierResponse;
import ru.yandex.yandexlavka.response.GetCourierMetaInfoResponse;
import ru.yandex.yandexlavka.response.GetCouriersResponse;
import ru.yandex.yandexlavka.service.courier.CourierService;

import java.time.LocalDate;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
@Validated
public class CourierController {
    private final CourierService courierService;

    @PostMapping
    public CreateCourierResponse postCouriers(
            @RequestBody @Valid CreateCourierRequest createCourierRequest
    ) {
        return courierService.createCouriers(createCourierRequest);
    }

    @GetMapping
    public GetCouriersResponse getCouriers(
            @RequestParam(defaultValue = "1", required = false) @Min(0) int limit,
            @RequestParam(defaultValue = "0", required = false) @Min(0) int offset
    ) {
        return courierService.getCouriersWithLimitAndOffset(limit, offset);
    }

    @GetMapping("/{courier_id}")
    public CourierDto getCourier(@PathVariable(name = "courier_id") long courierId) {
        return courierService.getCourierByIdOrThrow(courierId);
    }

    @GetMapping("/meta-info/{courier_id}")
    public GetCourierMetaInfoResponse getCourierMetaInfo(
            @PathVariable(name = "courier_id") long courierId,
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate
            ){
        return courierService.getCourierMetaInfoByIdAndStartDateAndEndDate(courierId, startDate, endDate);
    }


}
