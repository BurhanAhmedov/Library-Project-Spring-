package com.example.bookstorespring.service;

import com.example.bookstorespring.dto.BookDto;
import com.example.bookstorespring.mapper.BookDTOMapper;
import com.example.bookstorespring.mapper.BookRequestMapper;
import com.example.bookstorespring.model.Book;
import com.example.bookstorespring.repository.BookRepository;
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


    @Override
    public BookDto createBook(BookRequest request) {
        Book book = BookRequestMapper.mapFromRequest(request);
        Book creatingBook = bookRepository.save(book);


        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(creatingBook, bookDto);
        return bookDto;

    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        if (!bookList.isEmpty()) {
            log.info("Book List is ready");

            List<BookDto> bookDtoList = bookList
                    .stream()
                    .map(BookDTOMapper::mapFromBook)
                    .collect(Collectors.toList());
            log.info("Booklist successfully mapped to BookDTO bookDtoList");

/*        List<BookDto> bookDtoList = bookList
                .stream()
                .map(book -> {
                    return BookDTOMapper.mapFromBook(book);  //lambda
                })
                .collect(Collectors.toList());*/

            return bookDtoList;
        } else {
            log.error("Book List is empty");
            throw new NullPointerException();
        }
    }

    @Override
    public BookDto findBookById(long bookId) {

        Optional<Book> bookById = bookRepository.findById(bookId);
        if (bookById.isPresent()) {
            log.info("Book found");
            Book book = bookById.get();
            BookDto bookDto = BookDTOMapper.mapFromBook(book);
            log.info("Book is mapping to BookDto...");

            log.info("Book successfully mapped to BookDTO");

            return bookDto;
        } else {
            log.error("Book not found with specified id");
            throw new ProviderNotFoundException("Book not found with specified id");
        }
    }


    @Override
    public BookDto editBook(BookRequest request, long id) {
        log.info("Start");
        Optional<Book> findingBook = bookRepository.findById(id);
        log.info("Book found");


        if (findingBook.isPresent()) {

            Book newBook = findingBook.get();
            Book book = BookRequestMapper.mapFromRequest(request);

            newBook.setName(book.getName());
            newBook.setPrice(book.getPrice());
            newBook.setStock(book.getStock());
            log.info("Book informations edited");
            bookRepository.save(newBook);
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(newBook, bookDto);

            return bookDto;
        } else {
            log.error("Book not found");
            throw new NullPointerException("Book not found");
        }


    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }


}
