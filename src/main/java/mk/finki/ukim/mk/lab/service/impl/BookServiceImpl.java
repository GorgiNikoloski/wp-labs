package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.repository.AuthorRepository;
import mk.finki.ukim.mk.lab.repository.BookRepository;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
        Author author = authorRepository.findById(authorId).orElse(null);
        Book book = bookRepository.findByIsbn(isbn);

        if (author != null && book != null) {
            book.getAuthors().add(author);
        }
        return author;
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
