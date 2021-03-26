package com.example.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@ToString(exclude = "books")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Table(name = "libraries")
@Entity
public class Library {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Instant foundDate;

  @Column(name = "books_count")
  private Integer booksCount;
  private Boolean free;
  private Boolean longPeriod;

  @Transient
  private String coolField;

  @OneToMany(mappedBy = "library",
        fetch = FetchType.LAZY)
  private List<Book> books;


  public Library(Long id, String name, Instant foundDate, Integer booksCount, Boolean free, Boolean longPeriod) {
    this.id = id;
    this.name = name;
    this.foundDate = foundDate;
    this.booksCount = booksCount;
    this.free = free;
    this.longPeriod = longPeriod;
  }

    public Library() {
    coolField = "cool f";
  }

  public Library(String name, Instant foundDate, Integer booksCount) {
    this.name = name;
    this.foundDate = foundDate;
    this.booksCount = booksCount;
  }
}
