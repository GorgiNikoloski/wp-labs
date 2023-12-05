package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Book {

    private Long id;
    private String isbn;
    private String title;
    private String genre;
    private int year;
    private List<Author> authors;

    private BookStore bookStore;    // baranje 4


    public Book() {
        this.authors = new ArrayList<>();
    }

//    public Book(String isbn, String title, String genre, int year) {
//        this.id = (long) (Math.random() * 100);
//        this.isbn = isbn;
//        this.title = title;
//        this.genre = genre;
//        this.year = year;
//    }


//    public Book(String title, String isbn, String genre,int year, BookStore bookStore) {
//        this.isbn = isbn;
//        this.title = title;
//        this.genre = genre;
//        this.year = year;
//        this.bookStore = bookStore;
//    }

    public Book(String isbn, String title, String genre, int year, BookStore bookStore) {
        this.id = (long) (Math.random() * 100);
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.bookStore = bookStore;
    }
}
