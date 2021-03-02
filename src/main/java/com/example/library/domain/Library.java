package com.example.library.domain;

import java.time.Instant;
import java.util.Objects;

public class Library {
  private Long id;
  private String name;
  private Instant foundDate;
  private Integer booksCount;

  Library() {

  }

  public Library(String name, Instant foundDate, Integer booksCount) {
    this.name = name;
    this.foundDate = foundDate;
    this.booksCount = booksCount;
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

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Library library = (Library) o;
    return Objects.equals(name, library.name) && Objects.equals(foundDate, library.foundDate) && Objects
          .equals(booksCount, library.booksCount);
  }

  @Override public int hashCode() {
    return Objects.hash(name, foundDate, booksCount);
  }
}
