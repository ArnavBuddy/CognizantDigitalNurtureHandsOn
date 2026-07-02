package com.example.hibnative;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Uses org.hibernate.Session / SessionFactory directly - Hibernate's own
 * API, not the JPA-standard EntityManager. The byNaturalId() lookup below
 * is a Hibernate-only capability: there is no javax.persistence method that
 * does this. Compare this file to pure-jpa-demo's Main.java, which performs
 * the equivalent save-and-query using only javax.persistence types.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Hibernate Native API Demo ===");

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(new Book("978-0134685991", "Effective Java", "Joshua Bloch"));
            session.save(new Book("978-0132350884", "Clean Code", "Robert C. Martin"));
            session.save(new Book("978-0321349606", "Java Concurrency in Practice", "Brian Goetz"));
            tx.commit();
            System.out.println("3 Book records inserted via session.save().");
        }

        // Hibernate-native lookup by natural (business) key - no JPA equivalent
        try (Session session = sessionFactory.openSession()) {
            Book found = session.byNaturalId(Book.class)
                    .using("isbn", "978-0134685991")
                    .load();

            System.out.println();
            System.out.println("session.byNaturalId(Book.class).using(\"isbn\", ...).load():");
            System.out.println("  " + found);
        }

        try (Session session = sessionFactory.openSession()) {
            List<Book> books = session
                    .createQuery("from Book order by title", Book.class)
                    .list();

            System.out.println();
            System.out.println("All books (HQL: from Book order by title):");
            for (Book b : books) {
                System.out.println("  " + b);
            }
        }

        sessionFactory.close();
        System.out.println();
        System.out.println("SessionFactory closed. Done.");
    }
}
