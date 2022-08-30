package com.example.bookstorespring.repository;

import com.example.bookstorespring.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
