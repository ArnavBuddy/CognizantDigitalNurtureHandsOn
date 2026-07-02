package com.library.service;

/**
 * Service layer for book-related operations.
 * At this stage the service does not yet depend on BookRepository -
 * that wiring is introduced in Exercise 2 (Dependency Injection).
 */
public class BookService {

    public void addBook(String title) {
        System.out.println("BookService: received request to add book '" + title + "'");
    }
}
