package com.example.bookstorespring.service;


import com.example.bookstorespring.dto.GenreDTO;
import com.example.bookstorespring.mapper.GenreDTOMapper;
import com.example.bookstorespring.mapper.GenreRequestMapper;
import com.example.bookstorespring.model.Genre;
import com.example.bookstorespring.repository.GenreRepository;
import com.example.bookstorespring.request.GenreRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private ModelMapper modelMapper;
    private final GenreRepository genreRepository;

    @Override
    public GenreDTO createGenre(GenreRequest genreRequest) {
        Genre genre = GenreRequestMapper.mapFromRequest(genreRequest);

        Genre creatingGenre = genreRepository.save(genre);

        GenreDTO genreDTO = new GenreDTO();

        BeanUtils.copyProperties(creatingGenre, genreDTO);

        return genreDTO;
    }

    @Override
    public List<GenreDTO> getAllGenre() {
        List<Genre> genreList = genreRepository.findAll();

        if (!genreList.isEmpty()) {
            List<GenreDTO> genreDTOList = genreList.stream()
                    .map(GenreDTOMapper::mapFromGenre)
                    .collect(Collectors.toList());

            return genreDTOList;
        }
        throw new NullPointerException();
    }

    @Override
    public GenreDTO findGenreById(long id) {
        Optional<Genre> findingGenre = genreRepository.findById(id);

        if (findingGenre.isPresent()) {
            Genre genre = findingGenre.get();
            GenreDTO genreDTO = new GenreDTO();
            BeanUtils.copyProperties(genre, genreDTO);
            return genreDTO;
        }

        throw new NullPointerException("Genre not found!");
    }

    @Override
    public GenreDTO editGenre(GenreRequest genreRequest, long id) {
        Optional<Genre> findingGenre = genreRepository.findById(id);

        if (findingGenre.isPresent()) {
            Genre genre = findingGenre.get();

            Genre genreFromRequest = GenreRequestMapper.mapFromRequest(genreRequest);

            genre.setName(genreFromRequest.getName());
            genreRepository.save(genre);

            GenreDTO genreDTO = new GenreDTO();

            BeanUtils.copyProperties(genre, genreDTO);

            return genreDTO;

        }
        throw new NullPointerException("Genre not found!");
    }

    @Override
    public void deleteGenre(long id) {
        genreRepository.deleteById(id);
    }
}
