package com.springboot.rest.bootrestapi.services;

import com.springboot.rest.bootrestapi.dto.BookRequest;
import com.springboot.rest.bootrestapi.entities.Book;
import com.springboot.rest.bootrestapi.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book saveBook(BookRequest book) throws EntityNotFoundException;
    List<Book> fetchBookList();
    Book fetchBook(Long bookId) throws EntityNotFoundException;
    Book updateBook(BookRequest book, Long bookId) throws EntityNotFoundException;
    void deleteBook(Long bookId) throws EntityNotFoundException;
}
