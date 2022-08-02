package com.example.bookstorespring.mapper;

import com.example.bookstorespring.dto.BookDto;
import com.example.bookstorespring.model.Book;

public  class BookDTOMapper {

    public static BookDto mapFromBook(Book book){

        BookDto bookDto = new BookDto();

        bookDto.setPrice(book.getPrice());
        bookDto.setId(book.getId());
        bookDto.setStock(book.getStock());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        return bookDto;
    }

}
