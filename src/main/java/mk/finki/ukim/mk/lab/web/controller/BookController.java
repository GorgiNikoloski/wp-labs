package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import mk.finki.ukim.mk.lab.service.BookService;
import mk.finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookStoreService bookStoreService;

    public BookController(BookService bookService, BookStoreService bookStoreService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
    }


    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Book> books = this.bookService.listBooks();
        model.addAttribute("books", books);
        return "listBooks";
    }


    @GetMapping("/add-form")
    public String getAddBookPage(Model model) {
        List<BookStore> bookStores = this.bookStoreService.findAll();
        model.addAttribute("bookStores", bookStores);

//        model.addAttribute("bodyContent", "add-book");      // nezna zoshto e
        return "add-book";
    }


    @PostMapping("/add")
    public String saveBook(@RequestParam String title, @RequestParam String isbn, @RequestParam String genre,
                           @RequestParam int year, @RequestParam Long bookStoreId,@RequestParam(required = false) Long BookId) {

        this.bookService.save(title, isbn, genre, year, bookStoreId, BookId);
        return "redirect:/books";
    }


    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return "redirect:/books";
    }


    @GetMapping("/edit-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        if(this.bookService.findById(id).isPresent()){
            Book book = this.bookService.findById(id).get();
            List<BookStore> bookStores = this.bookStoreService.findAll();
            model.addAttribute("bookStores", bookStores);
            model.addAttribute("book", book);

//            model.addAttribute("bodyContent", "add-book");      // nezna zoshto e
            return "add-book";
        }
        return "redirect:/books?error=BookStoreNotFound";
    }


}
