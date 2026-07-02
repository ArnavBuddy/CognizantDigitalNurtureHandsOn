package com.library;

import org.springframework.stereotype.Service;

/**
 * Core service bean, managed by the Spring Context, that performs
 * basic library operations.
 */
@Service
public class LibraryService {

    public void addBook(Book book) {
        System.out.println("Book added to the library: " + book);
    }

    public void removeBook(Book book) {
        System.out.println("Book removed from the library: " + book);
    }
}
