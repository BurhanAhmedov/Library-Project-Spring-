package com.example.bookstorespring.request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {

    long id;
    String name;
    double price;
    int stock;
    List<Long> authorIds;

}
