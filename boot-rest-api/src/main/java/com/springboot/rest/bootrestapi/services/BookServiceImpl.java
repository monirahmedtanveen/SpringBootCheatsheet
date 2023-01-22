package com.springboot.rest.bootrestapi.services;

import com.springboot.rest.bootrestapi.dto.BookRequest;
import com.springboot.rest.bootrestapi.entities.Author;
import com.springboot.rest.bootrestapi.entities.Book;
import com.springboot.rest.bootrestapi.exception.EntityNotFoundException;
import com.springboot.rest.bootrestapi.repositories.AuthorRepository;
import com.springboot.rest.bootrestapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book saveBook(@RequestBody BookRequest bookRequest) throws EntityNotFoundException {
        Author author = authorRepository.findById(bookRequest.getAuthorId()).orElse(null);

        if (author == null) {
            throw new EntityNotFoundException("author not found with the specified identifier.");
        }

        Book book = Book.build(0, author, bookRequest.getTitle(), bookRequest.getSubTitle(), bookRequest.getDescription(), bookRequest.getNumberOfPages());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBookList() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book fetchBook(Long bookId) throws EntityNotFoundException {
        Book bookDb = bookRepository.findById(bookId).orElse(null);

        if (bookDb == null) {
            throw new EntityNotFoundException("book not found with the specified identifier.");
        }

        return bookDb;
    }

    @Override
    public Book updateBook(@RequestBody BookRequest bookRequest, Long bookId) throws EntityNotFoundException {
        Book bookDb = bookRepository.findById(bookId).orElse(null);

        if (bookDb == null) {
            throw new EntityNotFoundException("book not found with the specified identifier.");
        }

        Author author = authorRepository.findById(bookRequest.getAuthorId()).orElse(null);

        if (author == null) {
            throw new EntityNotFoundException("author not found with the specified identifier.");
        }

        bookDb.setAuthor(author);
        bookDb.setTitle(bookRequest.getTitle());
        bookDb.setSubTitle(bookRequest.getSubTitle());
        bookDb.setDescription(bookRequest.getDescription());
        bookDb.setNumberOfPages(bookRequest.getNumberOfPages());

        return bookRepository.save(bookDb);
    }

    @Override
    public void deleteBook(Long bookId) throws EntityNotFoundException {
        Book bookDb = bookRepository.findById(bookId).orElse(null);

        if (bookDb == null) {
            throw new EntityNotFoundException("book not found with the specified identifier.");
        }

        bookRepository.deleteById(bookId);
    }
}
