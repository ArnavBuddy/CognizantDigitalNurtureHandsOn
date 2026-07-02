package com.library.repository;

/**
 * Repository responsible for persisting and retrieving Book data.
 * For this exercise it simulates storage with an in-memory message
 * so the Spring wiring can be demonstrated without a real database.
 */
public class BookRepository {

    public String findAll() {
        return "[The Hobbit, Clean Code, Effective Java]";
    }
}
