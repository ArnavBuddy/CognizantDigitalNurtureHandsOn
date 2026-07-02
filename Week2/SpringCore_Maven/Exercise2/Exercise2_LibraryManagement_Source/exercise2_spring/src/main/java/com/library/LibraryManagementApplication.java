package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

/**
 * Loads the Spring application context and verifies that Spring's IoC
 * container correctly injected BookRepository into BookService.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("Spring context loaded successfully.");
        System.out.println("Dependency injection check: "
                + (bookService.getBookRepository() != null ? "SUCCESS - BookRepository was injected" : "FAILURE - BookRepository is null"));

        bookService.addBook("The Hobbit");
        bookService.addBook("Clean Code");

        System.out.println("Books in repository: " + bookService.listBooks());
    }
}
