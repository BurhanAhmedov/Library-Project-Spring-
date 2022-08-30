package com.example.bookstorespring.mapper;

import com.example.bookstorespring.dto.AuthorDTO;
import com.example.bookstorespring.dto.BookDTO;
import com.example.bookstorespring.dto.GenreDTO;
import com.example.bookstorespring.model.Book;

import java.util.List;
import java.util.stream.Collectors;


public class BookDTOMapper {

    public static BookDTO mapFromBook(Book book) {

        BookDTO bookDto = new BookDTO();

        bookDto.setPrice(book.getPrice());
        bookDto.setId(book.getId());
        bookDto.setStock(book.getStock());
        bookDto.setName(book.getName());

        List<AuthorDTO> authorList = getAuthorDtoList(book);
        bookDto.setAuthorList(authorList);

        List<GenreDTO> genreDTOList = getGenreDtoList(book);
        bookDto.setGenreList(genreDTOList);

        return bookDto;
    }

    public static List<AuthorDTO> getAuthorDtoList(Book book) {
        return book.getAuthorList()
                .stream()
                .map(AuthorDTOMapper::mapFromAuthor)
                .collect(Collectors.toList());
    }

    public static List<GenreDTO> getGenreDtoList(Book book) {
        return book.getGenreList()
                .stream()
                .map(GenreDTOMapper::mapFromGenre)
                .collect(Collectors.toList());
    }


}
