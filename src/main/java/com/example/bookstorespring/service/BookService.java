package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.BookDto;
import com.example.bookstorespring.request.BookRequest;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    BookDto findBookById(long bookId);

    BookDto createBook(BookRequest request);

    void deleteBook(long id);

    BookDto editBook(BookRequest request, long id);

}
