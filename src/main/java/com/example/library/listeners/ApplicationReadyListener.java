package com.example.library.listeners;

import com.example.library.domain.Library;
import com.example.library.repositry.LibraryRepository;
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

  private final LibraryRepository libraryRepository;

  public ApplicationReadyListener(LibraryRepository libraryRepository) {
    this.libraryRepository = libraryRepository;
  }


  @EventListener(ApplicationReadyEvent.class)
  public void applicationReadyHandler() {
    Library library = libraryRepository.getById(4L).get();

    LOGGER.info("Library = {}", library);

    List<Library> libraries = libraryRepository.getAll();
    LOGGER.info("Libraries = {}", libraries);
  }
}
