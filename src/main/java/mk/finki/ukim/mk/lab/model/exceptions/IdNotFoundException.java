package mk.finki.ukim.mk.lab.model.exceptions;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException() {
        super("Id was not found");
    }
}
