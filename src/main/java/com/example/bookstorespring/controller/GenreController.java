package com.example.bookstorespring.controller;


import com.example.bookstorespring.dto.GenreDTO;
import com.example.bookstorespring.request.GenreRequest;
import com.example.bookstorespring.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreRequest genreRequest) {
        return ResponseEntity.ok(genreService.createGenre(genreRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> getAllGenre() {
        return ResponseEntity.ok(genreService.getAllGenre());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> findGenreById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.findGenreById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> editGenre(@RequestBody GenreRequest genreRequest, @PathVariable long id) {
        return ResponseEntity.ok(genreService.editGenre(genreRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGenre(@PathVariable long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.ok("Genre deleted successfuly!");
    }
}
