package com.library.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository responsible for persisting and retrieving Book data.
 * Uses an in-memory list to simulate storage so the Spring wiring
 * can be demonstrated without a real database.
 */
public class BookRepository {

    private final List<String> books = new ArrayList<>();

    public void save(String title) {
        books.add(title);
        System.out.println("BookRepository: saved '" + title + "' to the data store");
    }

    public String findAll() {
        return books.isEmpty()
                ? "[The Hobbit, Clean Code, Effective Java]"
                : books.toString();
    }
}
