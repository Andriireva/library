package com.example.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "library")
@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String genre;
  private String authorName;
  private Integer pageCount;
  private Instant publishedDate;
  private Boolean homeFriendly;

  @ManyToOne
  @JoinColumn(name = "library_id")
  @JsonBackReference
  private Library library;

  public Book(Long id, String genre, String authorName, Integer pageCount, Instant publishedDate, Boolean homeFriendly,
        Long libraryId) {
    this.id = id;
    this.genre = genre;
    this.authorName = authorName;
    this.pageCount = pageCount;
    this.publishedDate = publishedDate;
    this.homeFriendly = homeFriendly;
//    this.libraryId = libraryId;
  }
}
