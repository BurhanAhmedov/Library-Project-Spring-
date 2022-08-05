package com.example.bookstorespring.repository;

import com.example.bookstorespring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
