package dev.angelcruzl.librarymanagementsystem;

import dev.angelcruzl.librarymanagementsystem.entity.Book;
import dev.angelcruzl.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibraryManagementSystemApplication implements ApplicationRunner {
  @Autowired
  private BookService bookService;

  public static void main(String[] args) {
    SpringApplication.run(LibraryManagementSystemApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<Book> books = bookService.findAllBooks();

    if (books != null && books.isEmpty()) {
      Book book1 = Book.builder().name("Under the dome").description("A book by Stephen King").price(20.0).build();
      Book book2 = Book.builder().name("IT").description("A book by Stephen King").price(29.52).build();
      Book book3 = Book.builder().name("The Shining").description("A book by Stephen King").price(15.0).build();

      Arrays.asList(book1, book2, book3).forEach(b -> bookService.createBook(b));

      System.out.println("Books populated successfully");
    }
  }
}
