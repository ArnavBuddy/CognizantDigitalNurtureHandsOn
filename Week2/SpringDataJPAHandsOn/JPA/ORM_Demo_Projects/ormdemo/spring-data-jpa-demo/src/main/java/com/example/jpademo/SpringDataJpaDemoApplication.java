package com.example.jpademo;

import com.example.jpademo.model.Book;
import com.example.jpademo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * No SessionFactory, no hibernate.cfg.xml, no mapping file, no hand-written
 * DAO. Spring Boot auto-configures the DataSource, EntityManagerFactory,
 * and a working implementation of BookRepository at startup - all the code
 * below is business logic, not plumbing.
 */
@SpringBootApplication
public class SpringDataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            System.out.println("=== Spring Data JPA Demo ===");

            bookRepository.save(new Book("Effective Java", "Joshua Bloch", 45.99));
            bookRepository.save(new Book("Clean Code", "Robert C. Martin", 39.50));
            bookRepository.save(new Book("Java Concurrency in Practice", "Brian Goetz", 52.00));
            System.out.println("3 Book records inserted via bookRepository.save().");

            System.out.println();
            System.out.println("All books (bookRepository.findAll()):");
            List<Book> all = bookRepository.findAll();
            all.forEach(b -> System.out.println("  " + b));

            System.out.println();
            System.out.println("Books over $40 (derived query findByPriceGreaterThanOrderByPriceDesc):");
            bookRepository.findByPriceGreaterThanOrderByPriceDesc(40.0)
                    .forEach(b -> System.out.println("  " + b));

            System.out.println();
            System.out.println("Books by 'Joshua Bloch' (derived query findByAuthor):");
            bookRepository.findByAuthor("Joshua Bloch")
                    .forEach(b -> System.out.println("  " + b));

            System.out.println();
            System.out.println("Total book count: " + bookRepository.count());
        };
    }
}
