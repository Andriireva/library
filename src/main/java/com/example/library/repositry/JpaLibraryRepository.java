package com.example.library.repositry;

import com.example.library.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaLibraryRepository extends JpaRepository<Library, Long> {


//  @Query(nativeQuery = true, value = "select * from libraries where name like '%:1%'")
  Optional<Library> findByNameContains(String contains);

  List<Library> findAllByFoundDateAfter(Instant contains);
}
