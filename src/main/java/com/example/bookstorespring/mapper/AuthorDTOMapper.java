package com.example.bookstorespring.mapper;

import com.example.bookstorespring.dto.AuthorDTO;
import com.example.bookstorespring.model.Author;

public class AuthorDTOMapper {

    public static AuthorDTO mapFromAuthor(Author author) {

        AuthorDTO authorDto = new AuthorDTO();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());

        return authorDto;

    }


}
