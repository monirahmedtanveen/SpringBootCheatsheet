package com.springboot.rest.bootrestapi.services;

import com.springboot.rest.bootrestapi.dto.BookRequest;
import com.springboot.rest.bootrestapi.entities.Book;
import com.springboot.rest.bootrestapi.exception.UserNotFoundException;
import com.springboot.rest.bootrestapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(@RequestBody BookRequest bookRequest) {
        Book book = Book.build(0, bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getAuthorEmail(), bookRequest.getAuthorMobile(), bookRequest.getDescription());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBookList() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book fetchBook(Long bookId) throws UserNotFoundException {
        Book bookDb = bookRepository.findById(bookId).orElse(null);

        if (bookDb == null) {
            throw new UserNotFoundException("user not found with the specified identifier.");
        }

        return bookDb;
    }

    @Override
    public Book updateBook(@RequestBody BookRequest bookRequest, Long bookId) throws UserNotFoundException {
        Book bookDb = bookRepository.findById(bookId).orElse(null);

        if (bookDb == null) {
            throw new UserNotFoundException("user not found with the specified identifier.");
        }

        bookDb.setTitle(bookRequest.getTitle());
        bookDb.setAuthor(bookRequest.getAuthor());
        bookDb.setAuthorEmail(bookRequest.getAuthorEmail());
        bookDb.setAuthorMobile(bookRequest.getAuthorMobile());
        bookDb.setDescription(bookRequest.getDescription());

        return bookRepository.save(bookDb);
    }

    @Override
    public void deleteBook(Long bookId) throws UserNotFoundException {
        Book bookDb = bookRepository.findById(bookId).orElse(null);

        if (bookDb == null) {
            throw new UserNotFoundException("user not found with the specified identifier.");
        }

        bookRepository.deleteById(bookId);
    }
}
