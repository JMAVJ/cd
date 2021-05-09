package me.cd.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.cd.booksapi.models.Book;
import me.cd.booksapi.services.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BooksAPI {
    private final BookService bookService;

    public BooksAPI(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> getAll() {
        return bookService.getAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getById(@PathVariable("id") Long id) {
        return bookService.getById(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Book create(@RequestBody Book book) {
        Book newBook = new Book(book.getTitle(), book.getAuthor(), book.getPages());
        return bookService.save(newBook);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PATCH)
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book newData) {
        return bookService.update(id, newData);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
    }
}