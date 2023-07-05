package com.example.librarydemospringboot.controller;

import com.example.librarydemospringboot.model.Author;
import com.example.librarydemospringboot.model.Book;
import org.springframework.ui.Model;
import com.example.librarydemospringboot.service.AuthorService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //Method to display all authors
    @GetMapping("/authorlist")
    public String listOfAuthors(Model model) {
        model.addAttribute("listAuthors", authorService.getAllAuthors());
        return "authorlist";
    }

    //Method that adds new authors
    @GetMapping("/showNewAuthorForm")
    public String showNewAuthorForm(Model model) {
        //model attribute binds data
        Author author = new Author();
        model.addAttribute("Author", author);//key, value
        return "new_author";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("Author") Author author) {
        // save book db
        authorService.saveAuthor(author);
        return "redirect:authorlist";
    }

    //Method handler that updates
    @GetMapping("/showAuthorUpdateForm/{authorId}") //To bind bookId the parameter below is used
    public String showUpdateForm(@PathVariable(value = "authorId") Long authorId, Model model) {
        //gets books from book service
        Author author = authorService.getAuthorByAuthorId(authorId);

        //sets book object as a model attribute to pre-populate the form
        model.addAttribute("Author", author);
        return "update_author";//view being returned
    }

    @GetMapping("/deleteAuthor/{authorId}")
    public String deleteAuthor(@PathVariable (value = "authorId") Long authorId) {
        //deletes authors
        this.authorService.deleteAuthorByAuthorId(authorId);
        return "redirect:/";
    }

    @PostMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute("author") Author author) {
        System.out.println("Update Author method called"); // Add this line for debugging

        // Update book in the database
        authorService.saveAuthor(author);
        return "redirect:/";
    }



}
