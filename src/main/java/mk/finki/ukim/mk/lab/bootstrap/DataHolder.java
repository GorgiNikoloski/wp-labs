package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import jdk.jfr.Category;
import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHolder {
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

//    public static List avtori = new ArrayList();

    @PostConstruct
    public void init() {
        authors.add(new Author(1111L, "Gorgi", "Nikoloski", "Nema sto da se zboruva se e kazhano"));
        authors.add(new Author(22222L, "Mihaela", "Lazareska", "Edna od najdobrite mladi avtori"));
        authors.add(new Author(22222L, "Milan", "Boshkoski", "Poseduva ogromen talent"));
        authors.add(new Author(22222L, "Martina", "Dimitrova", "Ne mnogu dobra"));
        authors.add(new Author(22222L, "Vladimir", "Gogovski", "Simply the best!"));

        books.add(new Book("1231212", "Data Science", "Naucna", 2021, authors));
        books.add(new Book("ab", "Veb programiranje", "Programiranje", 2020, authors));
        books.add(new Book("ac", "Bazi na podatoci", "bazi", 2018, authors));
        books.add(new Book("ad", "Shabloni", "Shabloni", 2019, authors));
        books.add(new Book("ae", "Robotika", "Robotika", 2022, authors));

    }

}
