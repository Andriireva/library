package com.example.library.configuration;

import com.example.library.domain.Library;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class AppConfig {

  //  @Bean
  //  public Collection collection() {
  //    return new ArrayList();
  //  }

  @Bean
  @Primary
  public String getApplicationName() {
    return "Library app";
  }

  @Bean("myFavStringBean")
  public String getFamString() {
    return "Another String";
  }

  @Bean
  public Long coolLong() {
    return 5L;
  }

  @Bean
  public Float coolFloat() {
    return 6.0f;
  }

  @Bean
  public Number coolNumber() {
    return 6.0f;
  }

  @Bean
  public RowMapper<Library> libraryRowMapper() {
    return new BeanPropertyRowMapper<>(Library.class);
//    return (rs, rowNum) -> new Library(rs.getLong("id"), rs.getString("name"),
//          rs.getTimestamp("found_date").toInstant(), rs.getInt("books_count"),
//          rs.getBoolean("free"), rs.getBoolean("long_period"));
  }

  @Bean
  public RowMapper<Book> bookRowMapper() {
    return new BeanPropertyRowMapper<>(Book.class);
  }

  //  @Bean
  //  public LibraryRepository libraryRepositoryFisrt() {
  //    return new LibrRep();
  //  }

  //  @Bean
  //  public LibraryRepository libraryRepositorySecond() {
  //    return new LibrRep();
  //  }

}
