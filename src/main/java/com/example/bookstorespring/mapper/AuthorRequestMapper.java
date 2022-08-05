package com.example.bookstorespring.mapper;

import com.example.bookstorespring.model.Author;
import com.example.bookstorespring.request.AuthorRequest;
import org.springframework.beans.BeanUtils;

public class AuthorRequestMapper {

    public static Author mapFromRequest(AuthorRequest authorRequest) {
        Author author = new Author();

        BeanUtils.copyProperties(authorRequest, author);

        return author;
    }
}
