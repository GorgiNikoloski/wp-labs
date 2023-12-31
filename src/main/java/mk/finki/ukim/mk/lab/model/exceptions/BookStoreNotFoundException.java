package mk.finki.ukim.mk.lab.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookStoreNotFoundException extends RuntimeException{

    public BookStoreNotFoundException(Long id) {
        super(String.format("Book-Store with id %d was not found", id));
    }
}
