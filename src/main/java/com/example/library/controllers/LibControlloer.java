package com.example.library.controllers;

import com.example.library.domain.Library;
import com.example.library.dtos.LibraryDto;
import com.example.library.services.LibService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/libs", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibControlloer {

  private final LibService libService;

  @GetMapping
  public Library get() {
    return libService.getLibrary();
  }
}
