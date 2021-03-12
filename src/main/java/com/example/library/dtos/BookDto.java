package com.example.library.dtos;

import com.example.library.domain.Book;

import java.time.Instant;

public class BookDto {
  private Long id;
  private String genre;
  private String authorName;
  private Integer pageCount;
  private Instant publishedDate;
  private Boolean homeFriendly;

  public BookDto(Book book) {
    this.id = book.getId();
    this.genre = book.getGenre();
    this.authorName = book.getAuthorName();
    this.pageCount = book.getPageCount();
    this.publishedDate = book.getPublishedDate();
    this.homeFriendly = book.getHomeFriendly();
  }

  public static Book toDomain(BookDto bookDto) {
    return new Book();
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
}
