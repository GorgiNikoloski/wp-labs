package mk.finki.ukim.mk.lab.web.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;


@WebServlet(name = "book-list-servlelt", urlPatterns = "/listBooks")
public class BookListServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookService bookService;
    private final AuthorService authorService;

    public BookListServlet(SpringTemplateEngine springTemplateEngine, BookService bookService, AuthorService authorService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("books", this.bookService.listBooks());

        this.springTemplateEngine.process("listBooks.html", context, resp.getWriter());

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("bookIsbn");
//        bookService.findBookByIsbn(isbn);   // nee sigurno


        resp.sendRedirect("/author?isbn=" +isbn);
    }
}
