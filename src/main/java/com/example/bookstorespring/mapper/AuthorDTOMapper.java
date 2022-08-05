package com.example.bookstorespring.mapper;

import com.example.bookstorespring.dto.AuthorDto;
import com.example.bookstorespring.model.Author;

public class AuthorDTOMapper {

    public static AuthorDto mapFromAuthor(Author author) {

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());

        return authorDto;

    }


}
