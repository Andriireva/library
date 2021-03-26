package com.example.library.listeners;

import com.example.library.repositry.BookJpaRepository;
import com.example.library.repositry.JpaLibraryRepository;
import com.example.library.services.LibService;
import com.example.library.services.LibraryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ApplicationReadyListener {

  private final LibraryService libraryService;
  private final LibService libService;
  private final JpaLibraryRepository jpaLibraryRepository;
  private final BookJpaRepository bookJpaRepository;

  @EventListener(ApplicationReadyEvent.class)
  public void applicationReadyHandler() {

//    log.info("Library {}", libService.getLibrary().getBooks());

  }
}
