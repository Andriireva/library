package com.example.library.controllers;

import com.example.library.domain.Library;
import com.example.library.dtos.LibraryDto;
import com.example.library.exceptions.ResourceNotFoundException;
import com.example.library.services.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/libraries", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class LibraryController {

  private final LibraryService libraryService;

  @GetMapping(value = "/{id}")
  public LibraryDto getOne(@PathVariable Long id) {
    return libraryService.getById(id);
  }

  @GetMapping
  public List<LibraryDto> getAll() {
    return libraryService.getAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LibraryDto post(@RequestBody LibraryDto libraryDto) {
    return libraryService.create(libraryDto);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    libraryService.delete(id);
  }

  @PutMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  public LibraryDto update(
        @PathVariable Long id,
        @RequestBody LibraryDto libraryDto) {
    return libraryService.update(libraryDto, id);
  }

}
