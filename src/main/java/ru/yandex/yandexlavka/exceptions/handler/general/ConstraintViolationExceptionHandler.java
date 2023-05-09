package ru.yandex.yandexlavka.exceptions.handler.general;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.yandex.yandexlavka.response.BadRequestResponse;

@RestControllerAdvice
public class ConstraintViolationExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BadRequestResponse handleConstraintViolationExceptionHandler(ConstraintViolationException e) {
        return new BadRequestResponse();
    }
}
