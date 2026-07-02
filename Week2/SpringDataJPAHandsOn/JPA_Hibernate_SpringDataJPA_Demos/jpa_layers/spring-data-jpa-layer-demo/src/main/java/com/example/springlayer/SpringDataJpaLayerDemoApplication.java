package com.example.springlayer;

import com.example.springlayer.model.Book;
import com.example.springlayer.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class SpringDataJpaLayerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaLayerDemoApplication.class, args);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository, EntityManager entityManager) {
        return args -> {
            System.out.println("=== Spring Data JPA Layer Demo ===");

            // The EntityManager below is standard javax.persistence - Spring Boot
            // wired it up automatically. It shows the layer Spring Data JPA sits on.
            System.out.println("Underlying EntityManager delegate (JPA provider): "
                    + entityManager.getDelegate().getClass().getName());
            System.out.println("BookRepository implementation class at runtime: "
                    + bookRepository.getClass().getName());

            bookRepository.save(new Book("Effective Java", "Joshua Bloch", 45.99));
            bookRepository.save(new Book("Clean Code", "Robert C. Martin", 39.50));
            bookRepository.save(new Book("Java Concurrency in Practice", "Brian Goetz", 52.00));
            System.out.println();
            System.out.println("3 Book records inserted via bookRepository.save() - no EntityManager code written.");

            System.out.println();
            System.out.println("All books (bookRepository.findAll()):");
            bookRepository.findAll().forEach(b -> System.out.println("  " + b));

            System.out.println();
            System.out.println("Books by 'Joshua Bloch' (derived query findByAuthor - generated JPQL under the hood):");
            bookRepository.findByAuthor("Joshua Bloch").forEach(b -> System.out.println("  " + b));
        };
    }
}
