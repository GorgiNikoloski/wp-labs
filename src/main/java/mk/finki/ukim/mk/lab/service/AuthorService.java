package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> listAuthor();

    Author findById(Long id);

}
