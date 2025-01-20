package org.example.assignment_jsp.DaoLayer;

import org.example.assignment_jsp.Entity.User;

public interface CrudDao <T> extends SuperDao{
    boolean save(T user1);

    boolean Login(String email, String password);
}
