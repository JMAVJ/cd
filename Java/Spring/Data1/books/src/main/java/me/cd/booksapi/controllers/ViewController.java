package me.cd.booksapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import me.cd.booksapi.models.Book;
import me.cd.booksapi.services.BookService;

@Controller
public class ViewController {
    private final BookService bookService;

    public ViewController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getById(id);    
        model.addAttribute("book", book);
        return "book.jsp";
    }
}
