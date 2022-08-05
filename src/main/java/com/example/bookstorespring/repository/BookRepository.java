package com.example.bookstorespring.repository;

import com.example.bookstorespring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);
}
