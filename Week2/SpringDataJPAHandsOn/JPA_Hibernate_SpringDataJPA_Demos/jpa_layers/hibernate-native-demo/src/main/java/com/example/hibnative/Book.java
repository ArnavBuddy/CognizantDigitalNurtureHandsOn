package com.example.hibnative;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * @Id, @GeneratedValue, @Column are JPA annotations (also used in the
 * pure-jpa-demo). @NaturalId, however, is org.hibernate.annotations.NaturalId -
 * a Hibernate-only extension with no equivalent anywhere in the JPA
 * specification. It lets Hibernate's native API look a row up by a business
 * key (isbn) via session.byNaturalId(...) with its own caching behaviour.
 * This is the concrete evidence that Hibernate is "a superset" of JPA:
 * everything JPA requires, plus extra implementation-specific features.
 */
@Entity
@Table(name = "BOOK_HIB_NATIVE")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 150)
    private String author;

    public Book() {
    }

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", isbn='" + isbn + "', title='" + title + "', author='" + author + "'}";
    }
}
