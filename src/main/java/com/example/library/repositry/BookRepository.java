package com.example.library.repositry;


import com.example.library.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
  Optional<Book> getById(Long id);
  Optional<Book> create(Book library, Long libraryId);
  List<Book> create(List<Book> books, Long libraryId);
  Optional<Book> update(Book library, Long id);
  List<Book> getAll();
  void delete(Long id);

  List<Book> getAllByLibraryId(Long id);

  void deleteAllByLibraryId(Long id);

  void doSomething() throws Exception;
}
