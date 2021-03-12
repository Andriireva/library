package com.example.library.exceptions;

public class ResourceNotFoundException extends ApplicationException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
