package com.example.library.repositry;

import com.example.library.domain.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository {
  Optional<Library> getById(Long id);
  Optional<Library> create(Library library);
  Optional<Library> update(Library library, Long id);
  List<Library> getAll();
  void delete(Long id);
}
