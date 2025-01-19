package org.example.assignment_jsp;

import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class main {
    public static void main(String[] args) {
        Session sessionFactoryConfiguration = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = sessionFactoryConfiguration.beginTransaction();

    }
}
