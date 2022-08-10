package com.example.bookstorespring.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Id;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto {
    long id;
    String name;
    double price;
    int stock;
    AuthorDto author;


}
