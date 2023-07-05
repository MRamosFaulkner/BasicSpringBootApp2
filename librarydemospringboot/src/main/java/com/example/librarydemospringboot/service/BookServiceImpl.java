package com.example.librarydemospringboot.service;

import com.example.librarydemospringboot.model.Book;
import com.example.librarydemospringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    //Injecting book repo
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();//This should return a list of all books
    }

    @Override
    public void saveBook(Book book) { //This should save the books to the db
        this.bookRepository.save(book);
    }

    @Override
    public Book getBookByBookId(Long bookId) {
        Optional<Book> optional = bookRepository.findById(bookId);
        Book book = null;
        if(optional.isPresent()){
            book = optional.get();
        }else {
            throw new RuntimeException("Book not found for id :: " + bookId);
        }
        return book;
    }

    @Override
    public void deleteBookByBookId(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }


}
