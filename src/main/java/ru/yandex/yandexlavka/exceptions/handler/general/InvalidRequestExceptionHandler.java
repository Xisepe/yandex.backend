package ru.yandex.yandexlavka.exceptions.handler.general;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.yandexlavka.exceptions.general.InvalidRequestException;
import ru.yandex.yandexlavka.response.BadRequestResponse;

@RestControllerAdvice
public class InvalidRequestExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BadRequestResponse handleInvalidRequestException(InvalidRequestException e) {
        return new BadRequestResponse();
    }
}
