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

@WebServlet(name = "book-details", urlPatterns = "/author/books")
public class bookDetails extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookService bookService;

    public bookDetails(SpringTemplateEngine springTemplateEngine, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);


        context.setVariable("books", bookService.listBooks());

        this.springTemplateEngine.process("bookDetails.html", context, resp.getWriter());

    }


    // ovde trebat kako na bookLIst servlet da prata parametar pa posle da gi isfiltrira.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        this.bookService.findBookByIsbn(isbn);
        // OVA VO AUTHOR SERVLET
        resp.sendRedirect("/author/books?isbn=" + isbn);
    }
}
