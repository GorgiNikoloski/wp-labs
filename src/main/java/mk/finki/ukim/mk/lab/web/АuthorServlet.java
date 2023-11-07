package mk.finki.ukim.mk.lab.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.AuthorService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;


@WebServlet(name = "author", urlPatterns = "/author")
public class АuthorServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorService authorService;


    public АuthorServlet(SpringTemplateEngine springTemplateEngine, AuthorService authorService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("authors", this.authorService.listAuthor());

        this.springTemplateEngine.process("authorList.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
