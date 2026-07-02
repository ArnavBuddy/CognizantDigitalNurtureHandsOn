package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;
import com.library.service.BookService;

/**
 * Loads the Spring application context and verifies that the
 * BookService and BookRepository beans are configured correctly.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");

        System.out.println("Spring context loaded successfully.");
        System.out.println("bookService bean  : " + bookService);
        System.out.println("bookRepository bean: " + bookRepository);

        bookService.addBook("The Hobbit");
        System.out.println("Repository contents: " + bookRepository.findAll());
    }
}
