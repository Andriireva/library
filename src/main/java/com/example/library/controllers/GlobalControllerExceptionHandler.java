package com.example.library.controllers;

import com.example.library.exceptions.ApplicationException;
import com.example.library.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseBody
  public ErrorInfo handResourceNotFound(Exception exception ) {
    return new ErrorInfo(exception.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ApplicationException.class)
  @ResponseBody
  public ErrorInfo handleGenericBadre(Exception exception ) {
    return new ErrorInfo(exception.getMessage());
  }

}
