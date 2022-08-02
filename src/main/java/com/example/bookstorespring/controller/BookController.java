package com.example.bookstorespring.controller;

import com.example.bookstorespring.dto.BookDto;
import com.example.bookstorespring.request.BookRequest;
import com.example.bookstorespring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore")
@RequiredArgsConstructor

public class BookController {

    private final BookService bookService;

    @GetMapping("/allBooks")
    public ResponseEntity<List<BookDto>> getAllBooks(){
       return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/find/{id}")
    public BookDto findBookById(@PathVariable  long id){

        return  bookService.findBookById(id);
    }

    @PostMapping("/newBook")
    public ResponseEntity<BookDto> createBook(@RequestBody BookRequest request){
        return ResponseEntity.ok(bookService.createBook(request));
    }


    @PutMapping("/edit/book/{id}")
    public BookDto editBook(@RequestBody BookRequest request, @PathVariable long id){
        return bookService.editBook(request,id);
    }

    @DeleteMapping("/delete/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
