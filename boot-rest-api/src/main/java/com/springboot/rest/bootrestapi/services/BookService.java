package com.springboot.rest.bootrestapi.services;

import com.springboot.rest.bootrestapi.dto.BookRequest;
import com.springboot.rest.bootrestapi.entities.Book;
import com.springboot.rest.bootrestapi.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book saveBook(BookRequest book);
    List<Book> fetchBookList();
    Book fetchBook(Long bookId) throws UserNotFoundException;
    Book updateBook(BookRequest book, Long bookId) throws UserNotFoundException;
    void deleteBook(Long bookId) throws UserNotFoundException;
}
