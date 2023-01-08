package com.springboot.rest.bootrestapi.repositories;

import com.springboot.rest.bootrestapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
