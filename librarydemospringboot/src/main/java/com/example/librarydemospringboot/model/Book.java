package com.example.librarydemospringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name= "book")
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "BookID")
        private Long bookId;

        @Column(name = "title")
        @NotNull
        @NotEmpty
        @Size(min = 3, max = 30, message = "Title must be between 3 and 30")
        private String title;

        @Column(name = "author")
        @NotNull
        @NotEmpty
        @Size(min = 3, max = 30, message = "Title must be between 3 and 30")
        private String author;

        //@OneToMany(cascade = CascadeType.ALL)//Saves
        //@JoinColumn(name = "authorBooks", referencedColumnName = "bookId")

//        List<Author> authors = new ArrayList<>();

        //Constructor
        public Book(Long bookId, String title, String author) {
            super();
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public Book() {
            super();

        }

        public void setBookId(Long bookId) {
            this.bookId = bookId;
        }
        public Long getBookId() {
            return bookId;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
//
//        public List<Author> getAuthors() {
//            return authors;

//        public void setAuthors() {
//            this.authors = authors;
//        }
//
//    }

    //        @Override
//        public String toString() {
//            return "Book{" +
//                    "BookID=" + bookID +
//                    ", title='" + title + '\'' +
//                    ", author='" + author + '\'' +
//                    '}';
//        }
}