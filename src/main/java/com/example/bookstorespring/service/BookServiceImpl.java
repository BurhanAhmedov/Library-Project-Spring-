package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.BookDTO;
import com.example.bookstorespring.mapper.BookDTOMapper;
import com.example.bookstorespring.mapper.BookRequestMapper;
import com.example.bookstorespring.model.Author;
import com.example.bookstorespring.model.Book;
import com.example.bookstorespring.model.Genre;
import com.example.bookstorespring.repository.AuthorRepository;
import com.example.bookstorespring.repository.BookRepository;
import com.example.bookstorespring.repository.GenreRepository;
import com.example.bookstorespring.request.BookRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final GenreRepository genreRepository;


    @Override
    public BookDTO createBook(BookRequest request) {
        Book book = BookRequestMapper.mapFromRequest(request);

        List<Author> authorListById = authorRepository.findAllById(request.getAuthorIds());
        List<Genre> genreListById = genreRepository.findAllById(request.getGenreIds());
        if (!authorListById.isEmpty() && !genreListById.isEmpty()) {
            book.setAuthorList(authorListById);
            book.setGenreList(genreListById);
        } else {
            throw new NullPointerException("Author or Genre not found");
        }
        bookRepository.save(book);

        return BookDTOMapper.mapFromBook(book);

    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        if (!bookList.isEmpty()) {
            log.info("Book List is ready");

            List<BookDTO> bookDTOList = bookList
                    .stream()
                    .map(BookDTOMapper::mapFromBook)
                    .collect(Collectors.toList());
            log.info("Book list successfully mapped to BookDTO bookDtoList");

/*        List<BookDto> bookDtoList = bookList
                .stream()
                .map(book -> {
                    return BookDTOMapper.mapFromBook(book);  //lambda
                })
                .collect(Collectors.toList());*/

            return bookDTOList;
        } else {
            log.error("Book List is empty");
            throw new NullPointerException();
        }
    }

    @Override
    public BookDTO findBookById(long bookId) {

        Optional<Book> bookById = bookRepository.findById(bookId);
        if (bookById.isPresent()) {
            log.info("Book found");
            Book book = bookById.get();
            BookDTO bookDto = new BookDTO();
            BeanUtils.copyProperties(book, bookDto);
            log.info("Book is mapping to BookDto...");

            log.info("Book successfully mapped to BookDTO");

            return bookDto;
        } else {
            log.error("Book not found with specified id");
            throw new ProviderNotFoundException("Book not found with specified id");
        }
    }


    @Override
    public BookDTO editBook(BookRequest request, long id) {
        log.info("Start");
        Optional<Book> findingBook = bookRepository.findById(id);
        log.info("Book found");


        if (findingBook.isPresent()) {

            Book newBook = findingBook.get();
            Book book = BookRequestMapper.mapFromRequest(request);

            newBook.setName(book.getName());
            newBook.setPrice(book.getPrice());
            newBook.setStock(book.getStock());
            log.info("Book information edited");
            bookRepository.save(newBook);
            BookDTO bookDto = new BookDTO();
            BeanUtils.copyProperties(newBook, bookDto);

            return bookDto;
        } else {
            log.error("Book not found");
            throw new NullPointerException("Book not found");
        }


    }

    @Override
    public void saleBook(long id){
        Optional<Book> findingBook = bookRepository.findById(id);
        if (findingBook.isPresent()){
            Book book = findingBook.get();
            bookRepository.saleBook(book.getId());
        }else
            throw new NullPointerException("Book not found!");

    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }


}
