package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.DaoLayer.Dao.ProductsDao;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    @Override
    public Category getCategoryById(String category1) {
        return null;
    }

    @Override
    public List<Products> getProductsByCategory(String categoryId) {
        Transaction transaction = null;
        List<Products> products = new ArrayList<>();

        try  {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            // Begin the transaction
            transaction = session.beginTransaction();

            // Create and execute the HQL query
            String hql = "FROM Products p WHERE p.category.cid = :categoryId";
            Query<Products> query = session.createQuery(hql, Products.class);
            query.setParameter("categoryId", categoryId);
            products = query.getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Products getProductId(String id) {
        try {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            System.out.println("Fetching product with ID: " + id);


            String hql = "FROM Products WHERE pid = :id";
            Query<Products> query = session.createQuery(hql, Products.class);
            query.setParameter("id" , id);

            Products products = query.uniqueResult();

            transaction.commit();
            return products;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
