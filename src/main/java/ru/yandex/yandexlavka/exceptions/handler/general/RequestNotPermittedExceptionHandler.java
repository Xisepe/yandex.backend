package ru.yandex.yandexlavka.exceptions.handler.general;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.yandex.yandexlavka.response.TooManyRequests;

@RestControllerAdvice
public class RequestNotPermittedExceptionHandler {
    @ExceptionHandler(RequestNotPermitted.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ResponseBody
    public TooManyRequests handleRequestNotPermittedException(RequestNotPermitted e) {
        return new TooManyRequests();
    }
}
