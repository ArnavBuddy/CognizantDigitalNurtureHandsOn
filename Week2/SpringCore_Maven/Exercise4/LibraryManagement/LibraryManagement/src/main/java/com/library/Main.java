package com.library;

import com.library.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Entry point used to verify that the Maven project is wired correctly:
 * loads the Spring Context, resolves an AOP-advised bean, and exercises it.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Library Management Application ===");
        System.out.println("Starting Spring Context...");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Spring Context started successfully.");
        System.out.println();

        LibraryService libraryService = context.getBean(LibraryService.class);

        Book book1 = new Book("Effective Java", "Joshua Bloch");
        Book book2 = new Book("Clean Code", "Robert C. Martin");

        libraryService.addBook(book1);
        libraryService.addBook(book2);
        libraryService.removeBook(book1);

        context.close();
        System.out.println();
        System.out.println("Spring Context closed. Application finished.");
    }
}
