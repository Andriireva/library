package com.example.library.dtos;

import com.example.library.domain.Book;
import com.example.library.domain.Library;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@EqualsAndHashCode
public class LibraryDto {
  private Long id;
  private String name;
  private Instant foundDate;
  private Integer booksCount;
  private Boolean free;
  private Boolean longPeriod;
  private List<BookDto> books;

  public LibraryDto(Library library, List<Book> books) {
    this.id = library.getId();
    this.name = library.getName();
    this.foundDate = library.getFoundDate();
    this.free = library.getFree();
    this.booksCount = library.getBooksCount();
    this.longPeriod = library.getLongPeriod();
    this.books = !CollectionUtils.isEmpty(books) ?
          books.stream().map(BookDto::new).collect(Collectors.toList())
          : Collections.emptyList();
  }

  public LibraryDto(Library library) {
    this(library, library.getBooks());
  }

  public static Library toDomain(LibraryDto libraryDto) {
    return Library.builder()
          .name(libraryDto.getName())
          .name(libraryDto.getName())
          .name(libraryDto.getName())
          .name(libraryDto.getName())
          .name(libraryDto.getName())
          .build();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instant getFoundDate() {
    return foundDate;
  }

  public void setFoundDate(Instant foundDate) {
    this.foundDate = foundDate;
  }

  public Integer getBooksCount() {
    return booksCount;
  }

  public void setBooksCount(Integer booksCount) {
    this.booksCount = booksCount;
  }

  public Boolean getFree() {
    return free;
  }

  public void setFree(Boolean free) {
    this.free = free;
  }

  public Boolean getLongPeriod() {
    return longPeriod;
  }

  public void setLongPeriod(Boolean longPeriod) {
    this.longPeriod = longPeriod;
  }

  public List<BookDto> getBooks() {
    return books;
  }

  public void setBooks(List<BookDto> books) {
    this.books = books;
  }
}
