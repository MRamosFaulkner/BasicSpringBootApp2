package com.example.librarydemospringboot.service;

import com.example.librarydemospringboot.model.Book;

import java.util.List;

public interface BookService {

    //Methods
    List<Book> getAllBooks();
    void saveBook(Book book);

    Book getBookByBookId(Long bookId);

    void deleteBookByBookId(Long bookId);

}
