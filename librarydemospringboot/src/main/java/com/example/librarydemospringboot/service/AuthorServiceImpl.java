package com.example.librarydemospringboot.service;

import com.example.librarydemospringboot.model.Author;
import com.example.librarydemospringboot.model.Book;
import com.example.librarydemospringboot.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();//This should return a list of all authors
    }

    @Override
    public void saveAuthor(Author author) { //This should save the books to the db
        this.authorRepository.save(author);
    }

    @Override
    public Author getAuthorByAuthorId(Long authorId) {
        Optional<Author> optional = authorRepository.findById(authorId);
        Author author = null;
        if(optional.isPresent()){
            author = optional.get();
        }else {
            throw new RuntimeException("Author not found for id :: " + authorId);
        }
        return author;
    }

    @Override
    public void deleteAuthorByAuthorId(Long authorId) {
        this.authorRepository.deleteById(authorId);
    }
}
