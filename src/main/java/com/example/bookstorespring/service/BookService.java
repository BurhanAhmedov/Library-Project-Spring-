package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.BookDTO;
import com.example.bookstorespring.request.BookRequest;

import java.util.List;

public interface BookService {
    BookDTO createBook(BookRequest request);

    List<BookDTO> getAllBooks();

    BookDTO findBookById(long bookId);


    BookDTO editBook(BookRequest request, long id);

    void saleBook(long id);

    void deleteBook(long id);

}
