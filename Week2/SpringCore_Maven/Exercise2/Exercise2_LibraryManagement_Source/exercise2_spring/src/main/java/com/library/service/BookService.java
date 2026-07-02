package com.library.service;

import com.library.repository.BookRepository;

/**
 * Service layer for book-related operations.
 * BookRepository is injected by Spring via a setter method (setter-based
 * Dependency Injection), configured in applicationContext.xml.
 */
public class BookService {

    private BookRepository bookRepository;

    /** Setter used by Spring's IoC container to inject the repository. */
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void addBook(String title) {
        bookRepository.save(title);
    }

    public String listBooks() {
        return bookRepository.findAll();
    }
}
