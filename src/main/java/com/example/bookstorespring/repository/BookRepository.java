package com.example.bookstorespring.repository;

import com.example.bookstorespring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);
    Optional<Book> findByAuthorAndName(String author, String name);
}
