package com.example.library.domain;

import java.time.Instant;
import java.util.Objects;

public class Library {
  private Long id;
  private String name;
  private Instant foundDate;
  private Integer booksCount;
  private Boolean free;
  private Boolean longPeriod;

  Library() {

  }

  public Library(Long id, String name, Instant foundDate, Integer booksCount, Boolean free, Boolean longPeriod) {
    this.id = id;
    this.name = name;
    this.foundDate = foundDate;
    this.booksCount = booksCount;
    this.free = free;
    this.longPeriod = longPeriod;
  }

  public Library(String name, Instant foundDate, Integer booksCount) {
    this.name = name;
    this.foundDate = foundDate;
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
    return Objects.equals(id, library.id) && Objects.equals(name, library.name) && Objects
          .equals(foundDate, library.foundDate) && Objects.equals(booksCount, library.booksCount) && Objects
          .equals(free, library.free) && Objects.equals(longPeriod, library.longPeriod);
  }

  @Override public int hashCode() {
    return Objects.hash(id, name, foundDate, booksCount, free, longPeriod);
  }

  @Override public String toString() {
    return "Library{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", foundDate=" + foundDate +
          ", booksCount=" + booksCount +
          ", free=" + free +
          ", longPeriod=" + longPeriod +
          '}';
  }
}
