package com.example.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author david
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class WebExceptionHandler {
    @ExceptionHandler(Exception.class)
    public MessageResult unknownException(Exception e) {
        log.error("exception "+e.getMessage());
        return MessageResult.createFailResult(e.getMessage());
    }

}
