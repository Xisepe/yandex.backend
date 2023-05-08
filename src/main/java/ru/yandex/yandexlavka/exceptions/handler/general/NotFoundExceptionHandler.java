package ru.yandex.yandexlavka.exceptions.handler.general;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.yandex.yandexlavka.exceptions.general.NotFoundException;
import ru.yandex.yandexlavka.response.NotFoundResponse;

@ControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public NotFoundResponse handleNotFoundException(NotFoundException e){
        return new NotFoundResponse();
    }
}
