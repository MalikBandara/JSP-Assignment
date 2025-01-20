package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.DaoLayer.Dao.ProductsDao;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductsDaoImpl implements ProductsDao {
    @Override
    public boolean save(Products user1) {

        Transaction transaction = null;
        try {

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            session.save(user1);
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e ){
            transaction.rollback();
            return false;

        }
    }

    @Override
    public boolean Login(String email, String password) {
        return false;
    }
}
