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
    double price;

    @Column(nullable = false)
    int stock;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    Author author;


}
