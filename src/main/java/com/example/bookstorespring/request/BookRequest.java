package com.example.bookstorespring.request;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {

    long id;
    String name;
    double price;
    int stock;
    long authorId;

}
