package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.DaoLayer.Dao.CartDao;
import org.example.assignment_jsp.Entity.Cart;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    @Override
    public boolean save(Cart cart) {
        Transaction transaction = null;
        try {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction =  session.beginTransaction();
            session.save(cart);
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
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
        return false;
    }

    @Override
    public boolean update(Cart cart) {
        return false;
    }

    @Override
    public List<Cart> getAll() {

        Transaction transaction = null ;

        try {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction =  session.beginTransaction();

            List<Cart> carts = new ArrayList<>();
            carts = session.createQuery("FROM Cart ", Cart.class).getResultList();

            System.out.println("Retrieved Products:");

            System.out.println("Retrieved Carts: " + carts);

            // Commit the transaction
            transaction.commit();
            session.close();
            return carts;

        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category getCategoryById(String category1) {
        return null;
    }
}
