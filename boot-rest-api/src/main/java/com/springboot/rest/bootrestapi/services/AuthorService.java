package com.springboot.rest.bootrestapi.services;

import com.springboot.rest.bootrestapi.dto.AuthorRequest;
import com.springboot.rest.bootrestapi.entities.Author;
import com.springboot.rest.bootrestapi.entities.Book;
import com.springboot.rest.bootrestapi.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<Author> fetchAuthorList();
    Author fetchAuthor(Long authorId) throws EntityNotFoundException;
    Author saveAuthor(AuthorRequest request);
    Author updateAuthor(AuthorRequest request, Long authorId) throws EntityNotFoundException;
    void deleteBook(Long authorId) throws EntityNotFoundException;
}
