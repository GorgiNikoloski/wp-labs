package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class BookRepository {

//    private List<Book> books;
//
//    public BookRepository() {
//        books = new ArrayList<>();
//
//        books.add(new Book("as", "Data Science", "Naucna", 2021, authors));
//        books.add(new Book("ab", "Veb programiranje", "Programiranje", 2020, avtori));
//        books.add(new Book("ac", "Bazi na podatoci", "bazi", 2018, avtori));
//        books.add(new Book("ad", "Shabloni", "Shabloni", 2019, avtori));
//        books.add(new Book("ae", "Robotika", "Robotika", 2022, avtori));
//    }

    public List<Book> findAll() {
        return DataHolder.books;
    }

    public Book findByIsbn(String isbn) {
        for (Book b : DataHolder.books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public Author addAuthorToBook(Author author, Book book) {
        book.getAuthors().add(author);
        return author;
    }

    public Optional<Book> save(String isbn, String title, String genre, int year, BookStore bookStore, Long BookId) {
        DataHolder.books.removeIf(i -> i.getId().equals(BookId));
        Book book = new Book(isbn, title, genre, year, bookStore);
        DataHolder.books.add(book);
        return Optional.of(book);
    }

    //probno
    public Optional<Book> findByTitle(String title) {
        return DataHolder.books.stream()
                .filter(i -> i.getTitle().equals(title))
                .findFirst();
    }

    public Optional<Book> findById(Long id) {
        return DataHolder.books.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        DataHolder.books.removeIf(i -> i.getId().equals(id));
    }
}
