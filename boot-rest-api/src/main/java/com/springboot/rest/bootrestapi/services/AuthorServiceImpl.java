package com.springboot.rest.bootrestapi.services;

import com.springboot.rest.bootrestapi.dto.AuthorRequest;
import com.springboot.rest.bootrestapi.entities.Author;
import com.springboot.rest.bootrestapi.exception.EntityNotFoundException;
import com.springboot.rest.bootrestapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> fetchAuthorList() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author fetchAuthor(Long authorId) throws EntityNotFoundException {
        Author author = authorRepository.findById(authorId).orElse(null);

        if (author == null) {
            throw new EntityNotFoundException("author not found with the specified identifier");
        }

        return author;
    }

    @Override
    public Author saveAuthor(AuthorRequest request) {
        Author author = new Author(request.getName(), request.getEmail(), request.getMobileNumber());
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(AuthorRequest request, Long authorId) throws EntityNotFoundException {
        Author author = authorRepository.findById(authorId).orElse(null);

        if (author == null) {
            throw new EntityNotFoundException("author not found with the specified identifier");
        }

        author.setName(request.getName());
        author.setEmail(request.getEmail());
        author.setMobileNumber(request.getMobileNumber());

        return authorRepository.save(author);
    }

    @Override
    public void deleteBook(Long authorId) throws EntityNotFoundException {
        Author author = authorRepository.findById(authorId).orElse(null);

        if (author == null) {
            throw new EntityNotFoundException("author not found with the specified identifier.");
        }

        authorRepository.deleteById(authorId);
    }
}
