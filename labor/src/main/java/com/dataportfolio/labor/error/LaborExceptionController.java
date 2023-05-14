package com.dataportfolio.labor.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class LaborExceptionController {

    @ResponseStatus(value = HttpStatus.TOO_MANY_REQUESTS, reason = "You have reach your limit")
    @ExceptionHandler(TooManyRequestException.class)
    public void handleTooManyRequest() {
        log.error("Too many request, your limit has been exceeded");
    }
}
