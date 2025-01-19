package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.DaoLayer.Dao.UserDao;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(User user) {
        // Get the session from the session factory (which uses connection pooling)
        Session session = null;
        Transaction transaction = null;
        boolean isSaved = false;

        try {
            // Start the session and transaction
            session = SessionFactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            // Save the user entity
            session.save(user);
            transaction.commit();
            isSaved = true; // Set to true if save was successful

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback transaction on failure
            }
            e.printStackTrace(); // Log the exception
        } finally {
            if (session != null) {
                session.close(); // Always close the session to release the connection back to the pool
            }
        }

        return isSaved; // Return whether the save operation was successful
    }
}
