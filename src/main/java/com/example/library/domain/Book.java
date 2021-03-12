package com.example.library.domain;

import java.time.Instant;
import java.util.Objects;

public class Book {
  private Long id;
  private String genre;
  private String authorName;
  private Integer pageCount;
  private Instant publishedDate;
  private Boolean homeFriendly;
  private Long libraryId;

  public Book() {
  }

  public Book(Long id, String genre, String authorName, Integer pageCount, Instant publishedDate, Boolean homeFriendly,
        Long libraryId) {
    this.id = id;
    this.genre = genre;
    this.authorName = authorName;
    this.pageCount = pageCount;
    this.publishedDate = publishedDate;
    this.homeFriendly = homeFriendly;
    this.libraryId = libraryId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public Integer getPageCount() {
    return pageCount;
  }

  public void setPageCount(Integer pageCount) {
    this.pageCount = pageCount;
  }

  public Instant getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(Instant publishedDate) {
    this.publishedDate = publishedDate;
  }

  public Boolean getHomeFriendly() {
    return homeFriendly;
  }

  public void setHomeFriendly(Boolean homeFriendly) {
    this.homeFriendly = homeFriendly;
  }

  public Long getLibraryId() {
    return libraryId;
  }

  public void setLibraryId(Long libraryId) {
    this.libraryId = libraryId;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Book book = (Book) o;
    return Objects.equals(id, book.id) && Objects.equals(genre, book.genre) && Objects
          .equals(authorName, book.authorName) && Objects.equals(pageCount, book.pageCount) && Objects
          .equals(publishedDate, book.publishedDate) && Objects.equals(homeFriendly, book.homeFriendly) && Objects
          .equals(libraryId, book.libraryId);
  }

  @Override public int hashCode() {
    return Objects.hash(id, genre, authorName, pageCount, publishedDate, homeFriendly, libraryId);
  }

  @Override public String toString() {
    return "Book{" +
          "id=" + id +
          ", genre='" + genre + '\'' +
          ", authorName='" + authorName + '\'' +
          ", pageCount=" + pageCount +
          ", publishedDate=" + publishedDate +
          ", homeFriendly=" + homeFriendly +
          ", libraryId=" + libraryId +
          '}';
  }
}
