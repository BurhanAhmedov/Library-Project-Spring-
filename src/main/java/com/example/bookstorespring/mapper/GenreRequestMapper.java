package com.example.bookstorespring.mapper;

import com.example.bookstorespring.model.Genre;
import com.example.bookstorespring.request.GenreRequest;
import org.springframework.beans.BeanUtils;

public class GenreRequestMapper {
    public static Genre mapFromRequest(GenreRequest genreRequest) {
        Genre genre = new Genre();
        BeanUtils.copyProperties(genreRequest, genre);

        return genre;
    }
}
