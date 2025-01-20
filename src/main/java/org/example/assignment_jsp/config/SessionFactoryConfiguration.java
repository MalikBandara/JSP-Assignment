package org.example.assignment_jsp.config;

import org.example.assignment_jsp.Entity.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {

    private static SessionFactory sessionFactory;

    // Private constructor to prevent instantiation
    private SessionFactoryConfiguration() {}

    // Singleton pattern with a static inner class
    public static SessionFactoryConfiguration getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Method to get the current session
    public Session getSession() {
        return sessionFactory.openSession();
    }

    // Static block to initialize the session factory
    static {
        try {
            // Load the Hibernate configuration and create the SessionFactory
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // You can specify the config file here
            configuration.addAnnotatedClass(org.example.assignment_jsp.Entity.User.class).addAnnotatedClass(Products.class); // Add annotated entity class(es)
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("SessionFactory initialization failed: " + e.getMessage());
        }
    }

    // Static inner class for SingletonHelper (thread-safe lazy initialization)
    private static class SingletonHelper {
        private static final SessionFactoryConfiguration INSTANCE = new SessionFactoryConfiguration();
    }
}
