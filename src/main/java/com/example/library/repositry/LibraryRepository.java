package com.example.library.repositry;

import com.example.library.domain.Library;

import java.util.List;

public interface LibraryRepository {
  Library getById(Long id);
  List<Library> getAll();
  void delete(Long id);
}
