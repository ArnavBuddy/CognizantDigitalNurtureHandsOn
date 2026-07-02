package com.example.purejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * IMPORTANT: not a single org.hibernate.* import appears anywhere in this
 * class. Everything used here - Persistence, EntityManagerFactory,
 * EntityManager, TypedQuery, JPQL - is part of the JPA specification
 * (JSR 338). Hibernate is doing all the real work underneath, but this code
 * would compile and run against EclipseLink or OpenJPA without a single
 * change, because it is written entirely against the spec, not the
 * implementation.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Pure JPA (Specification) Demo ===");

        // Persistence is a JPA class - it bootstraps whichever provider is
        // named in META-INF/persistence.xml (Hibernate, in this case).
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pure-jpa-demo-pu");
        EntityManager em = emf.createEntityManager();

        System.out.println("JPA provider in use: " + emf.getClass().getName());

        em.getTransaction().begin();
        em.persist(new Book("Effective Java", "Joshua Bloch", 45.99));
        em.persist(new Book("Clean Code", "Robert C. Martin", 39.50));
        em.persist(new Book("Java Concurrency in Practice", "Brian Goetz", 52.00));
        em.getTransaction().commit();
        System.out.println("3 Book records inserted via em.persist().");

        // JPQL - part of the JPA spec, database-independent
        TypedQuery<Book> query = em.createQuery(
                "SELECT b FROM Book b ORDER BY b.price DESC", Book.class);
        List<Book> books = query.getResultList();

        System.out.println();
        System.out.println("All books (JPQL: SELECT b FROM Book b ORDER BY b.price DESC):");
        for (Book b : books) {
            System.out.println("  " + b);
        }

        em.close();
        emf.close();
        System.out.println();
        System.out.println("EntityManager/EntityManagerFactory closed. Done.");
    }
}
