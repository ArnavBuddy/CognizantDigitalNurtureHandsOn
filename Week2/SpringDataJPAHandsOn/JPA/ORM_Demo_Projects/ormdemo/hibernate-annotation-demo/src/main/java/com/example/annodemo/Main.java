package com.example.annodemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Same behaviour as the XML demo, but the mapping information is read
 * from annotations on Book.java instead of a separate Book.hbm.xml file.
 * SessionFactory setup, transactions, and the HQL query are still all
 * written by hand.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Hibernate Annotation Configuration Demo ===");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")   // connection info still XML
                .addAnnotatedClass(Book.class)     // mapping comes from annotations
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(new Book("Effective Java", "Joshua Bloch", 45.99));
            session.save(new Book("Clean Code", "Robert C. Martin", 39.50));
            session.save(new Book("Java Concurrency in Practice", "Brian Goetz", 52.00));
            tx.commit();
            System.out.println("3 Book records inserted via session.save().");
        }

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
