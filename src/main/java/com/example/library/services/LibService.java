package com.example.library.services;

import com.example.library.domain.Library;
import com.example.library.repositry.JpaLibraryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class LibService {
  private final JpaLibraryRepository jpaLibraryRepository;

  public Library getLibrary() {
    Library library = jpaLibraryRepository.findById(8L)
          .orElseThrow(() -> new RuntimeException());

    log.info("{}", library.getBooks());
    return library;
  }
}
