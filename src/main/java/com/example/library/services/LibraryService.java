package com.example.library.services;

import com.example.library.dtos.LibraryDto;

import java.util.List;

public interface LibraryService {
  LibraryDto getById(Long id);
  LibraryDto create(LibraryDto library);
  LibraryDto update(LibraryDto library, Long id);
  List<LibraryDto> getAll();
  void delete(Long id);

}
