package com.example.bookstorespring.controller;

import com.example.bookstorespring.dto.AuthorDto;

import com.example.bookstorespring.request.AuthorRequest;
import com.example.bookstorespring.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/new/author")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.ok(authorService.createAuthor(authorRequest));

    }

    @GetMapping("/all/author")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> findAuthorById(@PathVariable long id) {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> editAuthor(@PathVariable long id, @RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.ok(authorService.editAuthor(authorRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(long id) {

        return ResponseEntity.ok("Author deleted successfully.");
    }


}
