package com.springboot.rest.bootrestapi.controller;

import com.springboot.rest.bootrestapi.dto.BookRequest;
import com.springboot.rest.bootrestapi.entities.Book;
import com.springboot.rest.bootrestapi.exception.UserNotFoundException;
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
@RequestMapping("/api/v1")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBookList() {
        List<Book> bookList = bookService.fetchBookList();
        if (bookList.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(bookList));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long bookId) throws UserNotFoundException {
        Book book = bookService.fetchBook(bookId);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody BookRequest bookRequest) {
        try {
            return ResponseEntity.of(Optional.of(bookService.saveBook(bookRequest)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody BookRequest bookRequest, @PathVariable("id") Long bookId) throws UserNotFoundException {
        return ResponseEntity.ok().body(bookService.updateBook(bookRequest, bookId));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long bookId) throws UserNotFoundException {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}
