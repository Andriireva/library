package com.example.library.domain;

import lombok.*;

import java.time.Instant;
import java.util.Objects;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
@Builder
public class Library {
  private Long id;
  private String name;
  private Instant foundDate;
  private Integer booksCount;
  private Boolean free;
  private Boolean longPeriod;

  public Library(String name, Instant foundDate, Integer booksCount) {
    this.name = name;
    this.foundDate = foundDate;
    this.booksCount = booksCount;
  }

}
