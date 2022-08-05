package com.example.bookstorespring.mapper;

import com.example.bookstorespring.model.Book;
import com.example.bookstorespring.request.BookRequest;
import org.springframework.beans.BeanUtils;

public class BookRequestMapper {

    public static Book mapFromRequest(BookRequest request) {
        Book book = new Book();

        BeanUtils.copyProperties(request, book);

        return book;

    }

}
