package com.example.librarydemospringboot.repository;

import com.example.librarydemospringboot.model.Book;
import com.example.librarydemospringboot.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Long> {

}
