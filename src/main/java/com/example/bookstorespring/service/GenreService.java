package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.GenreDTO;
import com.example.bookstorespring.request.GenreRequest;

import java.util.List;

public interface GenreService {

    GenreDTO createGenre(GenreRequest genreRequest);

    List<GenreDTO> getAllGenre();

    GenreDTO findGenreById(long id);

    GenreDTO editGenre(GenreRequest genreRequest, long id);

    void deleteGenre(long id);

}
