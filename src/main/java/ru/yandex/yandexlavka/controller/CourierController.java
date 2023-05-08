package ru.yandex.yandexlavka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.yandexlavka.request.CreateCourierRequest;
import ru.yandex.yandexlavka.response.CreateCourierResponse;

@RestController
@RequestMapping("/couriers")
public class CourierController {
    @PostMapping
    public CreateCourierResponse postCouriers(@RequestBody CreateCourierRequest createCourierRequest) {

        return null;
    }


}
