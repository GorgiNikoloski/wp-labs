package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookStoreRepository {

    public List<BookStore> findAll(){
        return DataHolder.bookStores;
    }

    public Optional<BookStore> findById(Long id){
        return DataHolder.bookStores.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

//    public Optional<Book> save(String title, String isbn, String genre, int year, BookStore bookstore) {
//        DataHolder.books.removeIf(i -> i.getTitle().equals(title));
//
//        Book book = new Book(title, isbn, genre, year, bookstore);
//        DataHolder.books.add(book);
//        return Optional.of(book);
//    }

//    public Optional<Book> save(String title, String isbn, String genre, int year, BookStore bookstore) {
//        DataHolder.books.removeIf(i -> i.getTitle().equals(title));
//
//    }
}
