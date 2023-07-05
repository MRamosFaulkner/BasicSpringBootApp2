package com.example.librarydemospringboot.controller;

import com.example.librarydemospringboot.model.Book;
import com.example.librarydemospringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    //Injects
    @Autowired
    private BookService bookService;

    //Method that displays list of all books
    @GetMapping("/booklist")
    public String listOfBooks(Model model) {
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "booklist";
    }

    //Method that adds new books
    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        //model attribute binds data
        Book book = new Book();
        model.addAttribute("Book", book);//key, value
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("Book") Book book) {
        // save book db
        bookService.saveBook(book);
        return "redirect:/";
    }

    //Method handler that updates
    @GetMapping("/showUpdateForm/{bookId}") //To bind bookId the parameter below is used
    public String showUpdateForm(@PathVariable (value = "bookId") Long bookId, Model model) {
        //gets books from book service
        Book book = bookService.getBookByBookId(bookId);

        //sets book object as a model attribute to pre-populate the form
        model.addAttribute("Book", book);
        return "update_book";//view being returned
    }

    @GetMapping("/deleteBook/{bookId}")
    public String delteBook(@PathVariable (value = "bookId") Long bookId) {
        //deletes books
        this.bookService.deleteBookByBookId(bookId);
        return "redirect:/";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book) {
        System.out.println("Update Book method called"); // Add this line for debugging

        // Update book in the database
        bookService.saveBook(book);
        return "redirect:/";
    }


}
