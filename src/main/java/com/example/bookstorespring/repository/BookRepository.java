package com.example.bookstorespring.repository;

import com.example.bookstorespring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = "update Book set stock=stock-1 where id=:id")
    void saleBook(Long id);



}
