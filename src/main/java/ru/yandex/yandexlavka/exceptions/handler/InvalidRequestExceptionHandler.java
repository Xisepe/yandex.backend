package ru.yandex.yandexlavka.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.yandex.yandexlavka.exceptions.general.InvalidRequestException;
import ru.yandex.yandexlavka.response.BadRequestResponse;

@ControllerAdvice
public class InvalidRequestExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BadRequestResponse handleInvalidRequestException(InvalidRequestException e) {
        return new BadRequestResponse();
    }
}
