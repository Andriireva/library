package com.example.library.repositry.impl;

import com.example.library.domain.Library;
import com.example.library.repositry.LibraryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class LibraryRepositoryImpl implements LibraryRepository {

  private final RowMapper<Library> libraryRowMapper;
  private final JdbcTemplate jdbcTemplate;

  public LibraryRepositoryImpl(JdbcTemplate jdbcTemplate,
          @Qualifier("myFavStringBean") String myString,
          Number coolFloat,
          RowMapper<Library> libraryRowMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.libraryRowMapper = libraryRowMapper;
  }

  @Override
  public Optional<Library> getById(Long id) {
    try {
      Library library = jdbcTemplate.queryForObject("select * from libraries where id = ?",
            libraryRowMapper, id);
      return Optional.ofNullable(library);
    } catch (DataAccessException e) {
      return Optional.empty();
    }
  }

  @Override
  public Optional<Library> create(Library library) {
    GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement =
                  con.prepareStatement("INSERT INTO libraries (name, found_data, long_period, books_count, free) "
                        + "values(?, ?, ?, ?, ?)");
            preparedStatement.setString(1, library.getName());
            preparedStatement.setTimestamp(2, Timestamp.from(library.getFoundDate()));
            preparedStatement.setBoolean(3, library.getLongPeriod());
            preparedStatement.setInt(4, library.getBooksCount());
            preparedStatement.setBoolean(5, library.getFree());
            return preparedStatement;
          },
          generatedKeyHolder);
    long key = generatedKeyHolder.getKey().longValue();
    return getById(key);
  }

  @Override
  public Optional<Library> update(Library library, Long id) {
    jdbcTemplate.update("update libraries\n"
                + " set name = ?, "
                + "     books_count = ?, "
                + "     free = ?, "
                + "     found_data = ?, "
                + "     long_period = ? "
                + "where id = ?;",
          library.getName(), library.getBooksCount(),
          library.getFree(), Timestamp.from(library.getFoundDate()),
          library.getLongPeriod(), id);
    return getById(id);
  }

  @Override
  public List<Library> getAll() {
    return jdbcTemplate.query("select * from libraries", libraryRowMapper);
  }

  @Override
  public void delete(Long id) {
    jdbcTemplate.update("delete from libraries where id = ?", id);
  }
}
