package me.cd.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.cd.booksapi.models.Book;
import me.cd.booksapi.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    public Book getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book update(Long id, Book newData) {
        Optional<Book> optionalObject = bookRepository.findById(id);
        if (!optionalObject.isPresent()) {
            return null;
        }
        Book b = optionalObject.get();
        b.setTitle(newData.getTitle());
        b.setAuthor(newData.getAuthor());
        b.setPages(newData.getPages());
        return bookRepository.save(b);
    }
}