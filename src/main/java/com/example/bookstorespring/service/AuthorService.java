package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.AuthorDTO;
import com.example.bookstorespring.request.AuthorRequest;

import java.util.List;

public interface AuthorService {

    AuthorDTO createAuthor(AuthorRequest authorRequest);

    List<AuthorDTO> getAllAuthors();

    AuthorDTO findAuthorById(long id);

    void deleteAuthor(long id);

    AuthorDTO editAuthor(AuthorRequest authorRequest, long id);
}
