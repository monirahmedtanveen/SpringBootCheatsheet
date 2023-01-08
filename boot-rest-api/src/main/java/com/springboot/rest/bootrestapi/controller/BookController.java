package com.springboot.rest.bootrestapi.controller;

import com.springboot.rest.bootrestapi.entities.Book;
import com.springboot.rest.bootrestapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    public ResponseEntity<List<Book>> getBookList() {
        List<Book> bookList = bookService.fetchBookList();
        if (bookList.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(bookList));
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long bookId) {
        Book book = bookService.fetchBook(bookId);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/api/books")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        try {
            return ResponseEntity.of(Optional.of(bookService.saveBook(book)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/api/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Long bookId) {
        try {
            return ResponseEntity.of(Optional.of(bookService.updateBook(book, bookId)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long bookId) {
        try {
            bookService.deleteBook(bookId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
