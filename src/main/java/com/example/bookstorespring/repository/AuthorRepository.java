package com.example.bookstorespring.repository;

import com.example.bookstorespring.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<List<Author>> findAllById(long authorId);
}
