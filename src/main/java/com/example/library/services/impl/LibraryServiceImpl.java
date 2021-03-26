package com.example.library.services.impl;

import com.example.library.domain.Book;
import com.example.library.domain.Library;
import com.example.library.dtos.BookDto;
import com.example.library.dtos.LibraryDto;
import com.example.library.exceptions.ApplicationException;
import com.example.library.exceptions.ResourceNotFoundException;
import com.example.library.repositry.BookRepository;
import com.example.library.repositry.JpaLibraryRepository;
import com.example.library.repositry.LibraryRepository;
import com.example.library.services.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

  private final JpaLibraryRepository libraryRepository;
  private final BookRepository bookRepository;

  @Override
  @SneakyThrows
  public LibraryDto getById( Long id) {
    return libraryRepository.findById(id)
          .map(library -> new LibraryDto(library))
          .orElseThrow(() -> new ResourceNotFoundException("Library with id " + id + " is not found"));
  }

  @Override
  public LibraryDto create(LibraryDto libraryDto) {
    Library library = LibraryDto.toDomain(libraryDto);
    Library createdLibrary = libraryRepository.save(library);
    List<Book> createdBooks = null;
    if (libraryDto.getBooks() != null && !libraryDto.getBooks().isEmpty()) {
      createdBooks = bookRepository
            .create(libraryDto.getBooks().stream().map(BookDto::toDomain).collect(Collectors.toList()), createdLibrary.getId());
    }

    return new LibraryDto(createdLibrary, createdBooks);
  }

  @Override
  public void delete(Long id) {
    libraryRepository.findById(id).map(library -> {
//      bookRepository.deleteAllByLibraryId(id);
      libraryRepository.deleteById(id);
      return library;
    }).orElseThrow(() -> new ResourceNotFoundException("Library with id " + id + " is not found"));
  }

  @Override
  public List<LibraryDto> getAll() {
    return Arrays.asList(new LibraryDto(new Library(1L, "asdas", Instant.now(), null, null, null)),
          new LibraryDto(new Library(2L, "second", Instant.now(), null, null, null)));
  }

  @Override
  public LibraryDto update(LibraryDto library, Long id) {
    return null;
  }
}
