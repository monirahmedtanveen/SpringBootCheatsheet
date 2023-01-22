package com.springboot.rest.bootrestapi.repositories;

import com.springboot.rest.bootrestapi.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
