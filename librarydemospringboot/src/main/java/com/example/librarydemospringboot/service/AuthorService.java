package com.example.librarydemospringboot.service;

import com.example.librarydemospringboot.model.Author;
import com.example.librarydemospringboot.model.Book;

import java.util.List;

public interface AuthorService {
    //Methods
    List<Author> getAllAuthors();
    void saveAuthor(Author author);

    Author getAuthorByAuthorId(Long authorId);

    void deleteAuthorByAuthorId(Long authorId);
}
