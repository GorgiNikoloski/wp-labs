package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);

    Book findBookByIsbn(String isbn);

    Optional<Book> findById(Long id);

    Optional<Book>findByTitle(String title);    // probno

    Optional<Book> save(String title, String isbn, String genre, int year, Long bookStoreId, Long BookId);

    void deleteById(Long id);
}
