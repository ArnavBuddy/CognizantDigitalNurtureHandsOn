package com.example.jpademo.repository;

import com.example.jpademo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This one interface replaces every hand-written DAO method from the two
 * Hibernate demos: save(), findAll(), delete(), plus paging and sorting,
 * come for free from JpaRepository. "findByAuthor" below is a derived
 * query - Spring Data JPA generates the JPQL from the method name alone,
 * so it stays database-independent (works unchanged against H2, MySQL,
 * PostgreSQL, etc.).
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByPriceGreaterThanOrderByPriceDesc(double price);
}
