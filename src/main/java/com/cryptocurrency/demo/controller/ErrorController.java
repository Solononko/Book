package com.cryptocurrency.demo.controller;

import com.cryptocurrency.demo.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ErrorController {
@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ErrorResponse handlMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e)
{log.warn("Handling {} exception","MethodArgumentTypeMismatch" );
return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),e.getMessage());

}}
