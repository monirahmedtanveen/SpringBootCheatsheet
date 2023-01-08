package com.springboot.rest.bootrestapi.services;

import com.springboot.rest.bootrestapi.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book saveBook(Book book);
    List<Book> fetchBookList();
    Book fetchBook(Long bookId);
    Book updateBook(Book book, Long bookId);
    void deleteBook(Long bookId);
}
