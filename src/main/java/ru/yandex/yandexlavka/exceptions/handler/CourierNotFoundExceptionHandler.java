package ru.yandex.yandexlavka.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.yandex.yandexlavka.exceptions.courier.CourierNotFoundException;
import ru.yandex.yandexlavka.response.NotFoundResponse;

@ControllerAdvice
public class CourierNotFoundExceptionHandler {
    @ExceptionHandler(CourierNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public NotFoundResponse handleCourierNotFoundException(CourierNotFoundException e) {
        return new NotFoundResponse();
    }
}
