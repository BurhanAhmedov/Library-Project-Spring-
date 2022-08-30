package com.example.bookstorespring.controller;

import com.example.bookstorespring.dto.BookDTO;
import com.example.bookstorespring.request.BookRequest;
import com.example.bookstorespring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor

public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable long id) {

        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }


    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> editBook(@RequestBody BookRequest request, @PathVariable long id) {
        return ResponseEntity.ok(bookService.editBook(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
