package ru.yandex.yandexlavka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.exceptions.general.InvalidRequestException;
import ru.yandex.yandexlavka.request.CreateCourierRequest;
import ru.yandex.yandexlavka.response.CreateCourierResponse;
import ru.yandex.yandexlavka.response.GetCouriersResponse;
import ru.yandex.yandexlavka.service.courier.CourierService;
import ru.yandex.yandexlavka.service.validator.courier.CreateCourierRequestValidator;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {
    private final CourierService courierService;
    private final CreateCourierRequestValidator createCourierRequestValidator;

    @PostMapping
    public CreateCourierResponse postCouriers(
            @RequestBody CreateCourierRequest createCourierRequest,
            BindingResult bindingResult
    ) {
        createCourierRequestValidator.validate(createCourierRequest, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException();
        }
        return courierService.createCouriers(createCourierRequest);
    }

    @GetMapping
    public GetCouriersResponse getCouriers(
            @RequestParam(defaultValue = "1", required = false) int limit,
            @RequestParam(defaultValue = "0", required = false) int offset
    ) {
        try {
            return courierService.getCouriersByLimitAndOffset(limit, offset);
        } catch (NumberFormatException e) {
            throw new InvalidRequestException();
        }
    }


}
