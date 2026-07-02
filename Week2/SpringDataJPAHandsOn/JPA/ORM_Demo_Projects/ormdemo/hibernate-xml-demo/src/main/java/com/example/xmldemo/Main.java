package com.example.xmldemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Demonstrates the "classic" way of using Hibernate: every table is mapped
 * by hand in a *.hbm.xml file, and hibernate.cfg.xml wires the whole
 * SessionFactory together. Persisting and querying still requires writing
 * a DAO-style method for every operation - there is no repository
 * abstraction.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Hibernate XML Configuration Demo ===");

        // 1. Build the SessionFactory from hibernate.cfg.xml + Book.hbm.xml
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // 2. Save a few Book records
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(new Book("Effective Java", "Joshua Bloch", 45.99));
            session.save(new Book("Clean Code", "Robert C. Martin", 39.50));
            session.save(new Book("Java Concurrency in Practice", "Brian Goetz", 52.00));
            tx.commit();
            System.out.println("3 Book records inserted via session.save().");
        }

        // 3. Query everything back with HQL (Hibernate's DB-independent query language)
        try (Session session = sessionFactory.openSession()) {
            List<Book> books = session
                    .createQuery("from Book order by price desc", Book.class)
                    .list();

            System.out.println();
            System.out.println("All books (HQL: from Book order by price desc):");
            for (Book b : books) {
                System.out.println("  " + b);
            }
        }

        sessionFactory.close();
        System.out.println();
        System.out.println("SessionFactory closed. Done.");
    }
}
