package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.DaoLayer.Dao.ProductsDao;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProductsDaoImpl implements ProductsDao {
    @Override
    public boolean save(Products products) {

        Transaction transaction = null;
        try {

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            session.save(products);
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

    @Override
    public boolean delete(String id) {

        try {

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            Products products = session.get(Products.class, id);
            session.delete(products);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Products products) {
        Transaction transaction = null;
        try {

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            session.update(products);
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e ){
            transaction.rollback();
            return false;

        }
    }

    @Override
    public List<Products> getAll() {

        Transaction transaction = null ;

        try {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction =  session.beginTransaction();

            List<Products> products = new ArrayList<>();
            products = session.createQuery("FROM Products", Products.class).getResultList();

            System.out.println("Retrieved Products:");
            for (Products product : products) {
                System.out.println("ID: " + product.getPid() +
                        ", Name: " + product.getName() +
                        ", Price: " + product.getPrice() +
                        ", Quantity: " + product.getQty() +
                        ", Image: " + product.getImage());
            }

            // Commit the transaction
            transaction.commit();
            session.close();
            return products;

        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }
}
