package com.example.library.repositry.impl;

import com.example.library.domain.Book;
import com.example.library.repositry.BookRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {
  private final RowMapper<Book> bookRowMapper;
  private final JdbcTemplate jdbcTemplate;

  public BookRepositoryImpl(RowMapper<Book> bookRowMapper,
        JdbcTemplate jdbcTemplate) {
    this.bookRowMapper = bookRowMapper;
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Optional<Book> getById(Long id) {
    try {
      Book book = jdbcTemplate.queryForObject("select * from books where id = ?",
            bookRowMapper, id);
      return Optional.ofNullable(book);
    } catch (DataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<Book> create(Book book, Long libraryId) {
    GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement =
                  con.prepareStatement("insert into books(genre, page_count, date, author_name, home_friendly, library_id) "
                        + "values(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, book.getGenre());
            preparedStatement.setInt(2, book.getPageCount());
            preparedStatement.setTimestamp(3, Timestamp.from(book.getPublishedDate()));
            preparedStatement.setString(4, book.getAuthorName());
            preparedStatement.setBoolean(5, book.getHomeFriendly());
            preparedStatement.setLong(6, libraryId);
            return preparedStatement;
          },
          generatedKeyHolder);
    long key = generatedKeyHolder.getKey().longValue();
    return getById(key);
  }

  @Override public List<Book> create(List<Book> books, Long libraryId) {

    return null;
  }

  @Override
  public Optional<Book> update(Book book, Long id) {
    jdbcTemplate.update("update books"
                + "set author_name = ? "
                + "    genre = ? "
                + "    home_friendly = ? "
                + "    published_date = ? "
                + "    page_count = ? "
                + "where id = ?",
          book.getAuthorName(), book.getGenre(),
          book.getHomeFriendly(), Timestamp.from(book.getPublishedDate()),
          book.getPageCount(), id);
    return getById(id);
  }

  @Override
  public List<Book> getAll() {
    return jdbcTemplate.query("select * from books", bookRowMapper);
  }

  @Override
  public void delete(Long id) {
    jdbcTemplate.update("delete from books where id = ?", id);
  }

  @Override public List<Book> getAllByLibraryId(Long id) {
    return jdbcTemplate.query("select * from books where library_id = ?", bookRowMapper, id);
  }

  @Override public void deleteAllByLibraryId(Long id) {
    jdbcTemplate.update("delete from books where library_id = ?", id);
  }

  @Override public void doSomething() throws Exception {

  }
}
