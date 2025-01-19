package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.DaoLayer.Dao.UserDao;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(User user) {
        Session session = null;
        Transaction transaction = null;
        boolean isSaved = false;

        try {
            // Hash the user's password before saving
            String hashedPassword = hashPassword(user.getPassword());
            user.setPassword(hashedPassword);  // Set the hashed password for the user

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


    @Override
    public boolean Login(String email, String password) {
        Session session = null;
        Transaction transaction = null;
        boolean isAuthenticated = false;

        try {
            // Obtain the Hibernate session
            session = SessionFactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            // Query to retrieve the stored password associated with the email
            String hql = "SELECT u.Password FROM User u WHERE u.Email = :email";
            List<String> storedPasswords = session.createQuery(hql, String.class)
                    .setParameter("email", email)
                    .getResultList();

            if (storedPasswords.size() == 1) {
                // If exactly one user is found with the provided email
                String storedPassword = storedPasswords.get(0);
                System.out.println("Stored password (hashed): " + storedPassword); // Debugging line

                // Hash the entered password to compare with the stored password
                String hashedPassword = hashPassword(password);
                System.out.println("Hashed entered password: " + hashedPassword); // Debugging line

                // Compare the stored hashed password with the hashed entered password
                if (storedPassword.equals(hashedPassword)) {
                    isAuthenticated = true;
                    System.out.println("Login successful!");  // Debugging line
                } else {
                    System.out.println("Passwords do not match!");  // Debugging line
                }
            } else {
                System.out.println("No user found with the provided email!");  // Debugging line
            }

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // Handle exceptions and rollback in case of an error
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Replace with proper logging in production
        } finally {
            // Ensure the session is closed to release resources
            if (session != null) {
                session.close();
            }
        }

        return isAuthenticated;
    }


    // Method to hash the password (you should use a secure algorithm like SHA-256)
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder hashString = new StringBuilder();

        // Convert the hash bytes to a hexadecimal string
        for (byte b : hashBytes) {
            hashString.append(String.format("%02x", b));
        }

        return hashString.toString();
    }








}

