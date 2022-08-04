package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.AuthorDto;

import com.example.bookstorespring.request.AuthorRequest;


import java.util.List;

public interface AuthorService {

    AuthorDto createAuthor(AuthorRequest authorRequest);

    List<AuthorDto> getAllAuthors();

    AuthorDto findAuthorById(long id);

    void deleteAuthor(long id);

    AuthorDto editAuthor(AuthorRequest authorRequest,long id);
}
