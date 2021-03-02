package com.example.library.services;

import com.example.library.dtos.LibraryDto;

public interface LibraryService {
  LibraryDto get(Long id);
}
