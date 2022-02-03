package com.project.ipldashboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TeamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleTeamNotFoundException(TeamNotFoundException ex, WebRequest webRequest){
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.toString(),
                ex.getMessage(),
                new Date(),
                webRequest.getDescription(false)
        );
    }
}
