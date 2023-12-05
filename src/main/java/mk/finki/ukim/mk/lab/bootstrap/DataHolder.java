package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import jdk.jfr.Category;
import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHolder {
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<BookStore> bookStores = new ArrayList<>();

//    public static List avtori = new ArrayList();

    @PostConstruct
    public void init() {
        authors.add(new Author(1111L, "Gorgi", "Nikoloski", "Nema sto da se zboruva se e kazhano"));
        authors.add(new Author(22222L, "Mihaela", "Lazareska", "Edna od najdobrite mladi avtori"));
        authors.add(new Author(22222L, "Milan", "Boshkoski", "Poseduva ogromen talent"));
        authors.add(new Author(22222L, "Martina", "Dimitrova", "Ne mnogu dobra"));
        authors.add(new Author(22222L, "Vladimir", "Gogovski", "Simply the best!"));

        BookStore bookstore1 = new BookStore("Prosvetno delo", "Kichevo", "Partizanski Odredi");
        BookStore bookstore2 = new BookStore("Ne Prosvetno delo", "Skopje", "Ilindenska");
        BookStore bookstore3 = new BookStore("Finki", "Skopje", "Rugjer Boskovic");
        BookStore bookstore4 = new BookStore("Feit", "Skopje", "Boskovic Rugjer ");
        BookStore bookstore5 = new BookStore("Mashinski", "Skopje", "R. Boskovic");
        bookStores.add(bookstore1);
        bookStores.add(bookstore2);
        bookStores.add(bookstore3);
        bookStores.add(bookstore4);
        bookStores.add(bookstore5);


        books.add(new Book("1231212", "Data Science", "Naucna", 2021, bookstore1));
        books.add(new Book("ab", "Veb programiranje", "Programiranje", 2020, bookstore2));
        books.add(new Book("ac", "Bazi na podatoci", "bazi", 2018, bookstore3));
        books.add(new Book("ad", "Shabloni", "Shabloni", 2019, bookstore4));
        books.add(new Book("ae", "Robotika", "Robotika", 2022, bookstore5));



//        BookStore bookstore1 = new BookStore("Prosvetno delo", "Kichevo", "Partizanski Odredi");
//        BookStore bookstore2 = new BookStore("Ne Prosvetno delo", "Skopje", "Ilindenska");
//        BookStore bookstore3 = new BookStore("Finki", "Skopje", "Rugjer Boskovic");
//        BookStore bookstore4 = new BookStore("Feit", "Skopje", "Boskovic Rugjer ");
//        BookStore bookstore5 = new BookStore("Mashinski", "Skopje", "R. Boskovic");
//        bookStores.add(bookstore1);
//        bookStores.add(bookstore2);
//        bookStores.add(bookstore3);
//        bookStores.add(bookstore4);
//        bookStores.add(bookstore5);

//        bookStores.add(new BookStore("Prosvetno delo", "Kichevo", "Partizanski odredi"));
//        bookStores.add(new BookStore("Ne Prosvetno delo", "Skopje", "Ilindenska"));
//        bookStores.add(new BookStore("Finki", "Skopje", "Rugjer Boskovic"));
//        bookStores.add(new BookStore("Feit", "Skopje", "Boskovic Rugjer "));
//        bookStores.add(new BookStore("Mashinski", "Skopje", "R. Boskovic"));
    }

}
