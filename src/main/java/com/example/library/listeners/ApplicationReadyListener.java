package com.example.library.listeners;

import com.example.library.domain.Library;
import com.example.library.repositry.LibraryRepository;
import com.example.library.services.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationReadyListener {

  private static final Logger LOGGER =
        LoggerFactory.getLogger(ApplicationReadyListener.class);

  private final LibraryService libraryService;

  public ApplicationReadyListener(LibraryService libraryService) {
    this.libraryService = libraryService;
  }


  @EventListener(ApplicationReadyEvent.class)
  public void applicationReadyHandler() {
    libraryService.delete(6L);
  }
}
