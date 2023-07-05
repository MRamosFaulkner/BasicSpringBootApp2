package com.example.librarydemospringboot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class LibraryMngmntApp {
    //Method that displays homepage
    @GetMapping("/")
    public String viewHomePage() {
        return "index";

    }
}
