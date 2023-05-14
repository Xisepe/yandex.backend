package ru.yandex.yandexlavka.exceptions.handler.general;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.yandex.yandexlavka.response.BadRequestResponse;

@RestControllerAdvice
public class HttpMessageNotReadableExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BadRequestResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new BadRequestResponse();
    }
}
