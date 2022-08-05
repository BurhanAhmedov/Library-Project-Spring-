package com.example.bookstorespring.request;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {

    long id;
    String name;
    double price;
    int stock;
    long authorId;

}
