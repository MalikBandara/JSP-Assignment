package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.DaoLayer.Dao.CategoryDao;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.Entity.Products;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public boolean save(Category category) {
        Transaction transaction = null ;
        try {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction =  session.beginTransaction();
            session.save(category);
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e ){
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
        try {

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            Category categery = session.get(Category.class, id);
            session.delete(categery);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category category) {
        Transaction transaction = null;
        try {

            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e ){
            transaction.rollback();
            return false;

        }
    }

    @Override
    public List<Category> getAll() {
        Transaction transaction = null ;

        try {
            Session session = SessionFactoryConfiguration.getInstance().getSession();
            transaction =  session.beginTransaction();

            List<Category> categories = new ArrayList<>();
            categories = session.createQuery("FROM Category", Category.class).getResultList();

            // Commit the transaction
            transaction.commit();
            session.close();
            return categories;

        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }
}
