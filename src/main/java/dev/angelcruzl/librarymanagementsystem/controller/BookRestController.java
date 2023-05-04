package dev.angelcruzl.librarymanagementsystem.controller;

import dev.angelcruzl.librarymanagementsystem.entity.Book;
import dev.angelcruzl.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestController {
  @Autowired
  private BookService bookService;

  @GetMapping("/all")
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = bookService.findAllBooks();
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Long> addNewBook(@RequestBody Book book) {
    Book insertedBook = bookService.createBook(book);

    if (insertedBook == null) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(insertedBook.getId(), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity updateBook(@RequestBody Book book) {
    bookService.updateBook(book);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteBook(@PathVariable("id") Long id) {
    bookService.deleteBook(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
