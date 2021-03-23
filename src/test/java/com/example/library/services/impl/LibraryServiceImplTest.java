package com.example.library.services.impl;

import com.example.library.domain.Library;
import com.example.library.dtos.LibraryDto;
import com.example.library.exceptions.ResourceNotFoundException;
import com.example.library.repositry.BookRepository;
import com.example.library.repositry.LibraryRepository;
import com.example.library.repositry.impl.LibraryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class LibraryServiceImplTest {

  @InjectMocks
  private LibraryServiceImpl libraryService;

  @Mock
  private LibraryRepository libraryRepository;
  @Mock
  private BookRepository bookRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getById_existedLibraryNotExistedBooks_shouldReturnLibraryDtoWithoutBooks() {
    Long existedId = 6L;
    String bestLibrary = "Best library";
    Library libraryFromRepo = Library.builder()
          .id(existedId)
          .name(bestLibrary)
          .build();
    when(libraryRepository.getById(existedId))
          .thenReturn(Optional.of(libraryFromRepo));

    LibraryDto libraryDto = libraryService.getById(existedId);

    assertNotNull(libraryDto);
    assertEquals(existedId, libraryDto.getId());
    assertEquals(bestLibrary, libraryDto.getName());
    assertNotNull(libraryDto.getBooks());
    assertEquals(libraryDto.getBooks().size(), 0);
    verify(libraryRepository).getById(6L);
  }

  @Test
  void getById_existedLibraryExistedBooks_shouldReturnLibraryDtoWitBooks() {
    Long existedId = 6L;
    String bestLibrary = "Best library";
    Library libraryFromRepo = Library.builder()
          .id(existedId)
          .name(bestLibrary)
          .build();
    when(libraryRepository.getById(existedId))
          .thenReturn(Optional.of(libraryFromRepo));

    LibraryDto libraryDto = libraryService.getById(existedId);

    assertNotNull(libraryDto);
    assertEquals(existedId, libraryDto.getId());
    assertEquals(bestLibrary, libraryDto.getName());
    assertNotNull(libraryDto.getBooks());
    assertTrue(libraryDto.getBooks().size() > 0);
    //    assertEquals(new LibraryDto(libraryFromRepo), libraryDto);

  }

  @Test
  void getById_notExistedLibrary_shouldThorwResourceNotFoundException() {
    when(libraryRepository.getById(anyLong()))
          .thenReturn(Optional.empty());

    ResourceNotFoundException resourceNotFoundException
          = assertThrows(ResourceNotFoundException.class, () -> libraryService.getById(5L));
    assertEquals("Library with id 5 is not found", resourceNotFoundException.getMessage());
  }

  @Test
  void delete_existedLibrary_shouldCallRepositoriesDeleteMethods() {
    long existedId = 7L;
    when(libraryRepository.getById(existedId))
          .thenReturn(Optional.of(new Library()));

    libraryService.delete(existedId);

    verify(libraryRepository).delete(existedId);
    verify(bookRepository).deleteAllByLibraryId(existedId);

  }

  @Test
  void delete_notExistedLibrary_shouldThrowResourceNotFoundException() {
    long existedId = 7L;
    when(libraryRepository.getById(anyLong()))
          .thenReturn(Optional.empty());

    ResourceNotFoundException resourceNotFoundException =
          assertThrows(ResourceNotFoundException.class,
          () -> libraryService.delete(existedId));

    assertEquals("Library with id 7 is not found", resourceNotFoundException.getMessage());
    verify(libraryRepository, times(0)).delete(anyLong());
    verify(bookRepository, never()).deleteAllByLibraryId(anyLong());
  }

  @Test
  void create_libraryDtoWithoutBooks_shouldReturnNewDto() {
    LibraryDto libraryDto = new LibraryDto();
    libraryDto.setName("Awesome Library");
    when(libraryRepository.create(Library.builder().name("Awesome Library").build()))
          .thenReturn(Optional.of(Library.builder().id(78L).name("Awesome Library").build()));

    LibraryDto createdLibraryDto = libraryService.create(libraryDto);

    assertNotNull(createdLibraryDto);
    assertNotNull(createdLibraryDto.getId());
    assertEquals("Awesome Library", createdLibraryDto.getName());
    assertEquals(0, createdLibraryDto.getBooks().size());
    verify(libraryRepository).create(Library.builder().name("Awesome Library").build());
    verify(bookRepository, never()).create(anyList(), anyLong());
  }

  @Test
  void getAll() {
  }

  @Test
  void update() {
  }
}