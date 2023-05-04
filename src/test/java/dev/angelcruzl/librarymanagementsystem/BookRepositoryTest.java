package dev.angelcruzl.librarymanagementsystem;

import dev.angelcruzl.librarymanagementsystem.entity.Book;
import dev.angelcruzl.librarymanagementsystem.service.BookService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class BookRepositoryTest {
  @Autowired
  private BookService bookService;

  @Test
  public void GivenCreateBookThenExpectSameBook() {
    Book book = Book.builder()
        .name("The Lord of the Rings")
        .description("The Lord of the Rings is an epic high-fantasy novel written by English author and scholar J. R. R. Tolkien.")
        .price(16.33)
        .build();

    Book actual = bookService.createBook(book);

    assertEquals(book.getName(), actual.getName());
    assertEquals(book.getDescription(), actual.getDescription());
    assertEquals(book.getPrice(), actual.getPrice());
  }
}
