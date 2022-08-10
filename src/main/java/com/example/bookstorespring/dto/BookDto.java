package com.example.bookstorespring.dto;

import com.example.bookstorespring.model.Author;
import lombok.AccessLevel;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


import java.util.List;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    long id;
    String name;
    double price;
    int stock;
    List<Author> authorList;


}
