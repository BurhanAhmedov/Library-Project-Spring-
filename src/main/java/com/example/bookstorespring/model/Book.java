package com.example.bookstorespring.model;



import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String author;

    @Column(nullable = false)
    double price;

    @Column(nullable = false)
    int stock;

}
