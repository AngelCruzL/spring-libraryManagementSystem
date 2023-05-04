package dev.angelcruzl.librarymanagementsystem;

import dev.angelcruzl.librarymanagementsystem.entity.Book;
import dev.angelcruzl.librarymanagementsystem.repository.BookRepository;
import dev.angelcruzl.librarymanagementsystem.service.BookService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {
  @Autowired
  private BookService bookService;

  @MockBean
  private BookRepository bookRepository;

  @Test
  public void addBookExpectCreated() {
    Book book = Book.builder()
        .name("The Lord of the Rings")
        .description("The Lord of the Rings is an epic high-fantasy novel written by English author and scholar J. R. R. Tolkien.")
        .price(16.33)
        .build();

    bookService.createBook(book);

    Mockito.verify(bookRepository, Mockito.times(1)).save(book);
  }
}
