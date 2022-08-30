package com.example.bookstorespring.mapper;

import com.example.bookstorespring.dto.GenreDTO;
import com.example.bookstorespring.model.Genre;

public class GenreDTOMapper {

    public static GenreDTO mapFromGenre(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        return genreDTO;
    }
}
