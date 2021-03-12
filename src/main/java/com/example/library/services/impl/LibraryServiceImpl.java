package com.example.library.services.impl;

import com.example.library.domain.Library;
import com.example.library.dtos.BookDto;
import com.example.library.dtos.LibraryDto;
import com.example.library.exceptions.ResourceNotFoundException;
import com.example.library.repositry.BookRepository;
import com.example.library.repositry.LibraryRepository;
import com.example.library.services.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

  private final LibraryRepository libraryRepository;
  private final BookRepository bookRepository;

  @Override
  @SneakyThrows
  public LibraryDto getById(Long id) {

//    Library library = Library.builder()
//          .booksCount(5)
//          .free(true)
//          .build();

    bookRepository.doSomething();


    return libraryRepository.getById(id)
          .map(library -> new LibraryDto(library, bookRepository.getAllByLibraryId(id)))
          .orElseThrow(() -> new ResourceNotFoundException("Library with id " + id + " is not found"));
  }

  @Override
  public LibraryDto create(LibraryDto libraryDto) {
    Library library = LibraryDto.toDomain(libraryDto);
//    BookDto.toDomain(libraryDto.getBooks().iterator().next())
//    libraryRepository.create(library)
//          .map(createdLibrary -> {
//            bookRepository.create(libraryDto.
//                  getBooks().stream().map(bookDto -> BookDto.toDomain(bookDto)).collect(Collectors.toList()), library.getId());
//          });
    return new LibraryDto(null);
  }

  @Override
  public void delete(Long id) {
    bookRepository.deleteAllByLibraryId(id);
    libraryRepository.delete(id);
  }

  @Override
  public List<LibraryDto> getAll() {
    return null;
  }

  @Override
  public LibraryDto update(LibraryDto library, Long id) {
    return null;
  }
}
