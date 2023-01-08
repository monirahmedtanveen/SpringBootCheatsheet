package com.springboot.rest.bootrestapi.services;

import com.springboot.rest.bootrestapi.entities.Book;
import com.springboot.rest.bootrestapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBookList() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book fetchBook(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public Book updateBook(Book book, Long bookId) {
        Book bookDb = bookRepository.findById(bookId).get();

        if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
            bookDb.setTitle(book.getTitle());
        }

        if (Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
            bookDb.setAuthor(book.getAuthor());
        }

        if (Objects.nonNull(book.getDescription()) && !"".equalsIgnoreCase(book.getDescription())) {
            bookDb.setDescription(book.getDescription());
        }

        return bookRepository.save(bookDb);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
