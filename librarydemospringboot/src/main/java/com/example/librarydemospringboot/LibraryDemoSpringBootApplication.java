package com.example.librarydemospringboot;

import com.example.librarydemospringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LibraryDemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryDemoSpringBootApplication.class, args);
	}


}
