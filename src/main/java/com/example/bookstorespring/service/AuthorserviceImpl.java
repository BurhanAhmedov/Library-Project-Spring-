package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.AuthorDto;
import com.example.bookstorespring.mapper.AuthorDTOMapper;
import com.example.bookstorespring.mapper.AuthorRequestMapper;
import com.example.bookstorespring.model.Author;
import com.example.bookstorespring.repository.AuthorRepository;
import com.example.bookstorespring.request.AuthorRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorserviceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public AuthorDto createAuthor(AuthorRequest authorRequest) {

        Author author = AuthorRequestMapper.mapFromRequest(authorRequest);
        log.info("request map to author");
        authorRepository.save(author);
        log.info("author save");
        AuthorDto authorDto = new AuthorDto();

        BeanUtils.copyProperties(author, authorDto);
        log.info("author copy to dto");
        return authorDto;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {

        List<Author> authorList = authorRepository.findAll();

        if (!authorList.isEmpty()) {
            List<AuthorDto> authorDtoList = authorList.stream()
                    .map(AuthorDTOMapper::mapFromAuthor)
                    .collect(Collectors.toList());
            return authorDtoList;
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public AuthorDto findAuthorById(long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {

            Author findingAuthor = author.get();

            AuthorDto authorDto = new AuthorDto();

            BeanUtils.copyProperties(findingAuthor, authorDto);

            return authorDto;
        }

        throw new NullPointerException("Author not found!");

    }

    @Override
    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto editAuthor(AuthorRequest authorRequest, long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            Author authorFromRequest = AuthorRequestMapper.mapFromRequest(authorRequest);

            AuthorDto authorDto = new AuthorDto();

            author.setName(authorFromRequest.getName());
            author.setSurname(authorFromRequest.getSurname());
            authorRepository.save(author);

            BeanUtils.copyProperties(author, authorDto);

            return authorDto;

        }

        throw new NullPointerException("Author not found!");
    }
}
