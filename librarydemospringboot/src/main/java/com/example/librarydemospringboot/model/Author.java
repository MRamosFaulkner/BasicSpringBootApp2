package com.example.librarydemospringboot.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name= "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorID")
    private Long authorId;

    @Column(name = "AuthorName")
    private String name;
//
//    @Column(name = "AuthorBooks")
//    private String books;

//    @ManyToOne
//    @JoinColumn(name = "authorId")
//    private Book book;
//
//    public Author() {
//
//    }

    //Constructor
//    public Author(Long authorId, String name) {
//        super();
//        this.authorId= authorId;
//        this.name = name;
//    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    public Long getAuthorId() {
        return authorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//        @Override
//        public String toString() {
//            return "Book{" +
//                    "BookID=" + bookID +
//                    ", title='" + title + '\'' +
//                    ", author='" + author + '\'' +
//                    '}';
//        }
}
