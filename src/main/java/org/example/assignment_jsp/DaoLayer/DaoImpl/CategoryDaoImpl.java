package org.example.assignment_jsp.DaoLayer.DaoImpl;

import org.example.assignment_jsp.DaoLayer.Dao.CategoryDao;
import org.example.assignment_jsp.Entity.Category;
import org.example.assignment_jsp.config.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return false;
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
