package com.example.bookstorespring.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Id;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    @Id
    long id;

    String name;
    double price;
    int stock;
    AuthorDto author;


}
