package org.example.assignment_jsp.DaoLayer.Dao;

import org.example.assignment_jsp.DaoLayer.CrudDao;
import org.example.assignment_jsp.Entity.User;

public interface UserDao extends CrudDao<User> {
    String getUserRole(String email);

    User getUserId(String userid);
}
