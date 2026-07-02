package com.example.springlayer.repository;

import com.example.springlayer.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * No implementation body at all - Spring Data JPA generates a proxy at
 * startup that implements every method here (including the derived
 * "findByAuthor" query) by delegating to a plain javax.persistence.EntityManager
 * behind the scenes. That EntityManager is, in turn, backed by Hibernate.
 * This one interface is the entire "abstraction on top of Hibernate to
 * remove boilerplate" that Spring Data JPA provides.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
}
