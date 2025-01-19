package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.UserBo;
import org.example.assignment_jsp.DaoLayer.Dao.UserDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.dto.UserDto;

public class UserBoImpl implements UserBo {


    UserDao userDao = (UserDao) DaoFactory.getDaoFactory().getDao(DaoType.USER);

    @Override
    public boolean SaveUsers(UserDto user) {
        User user1 = new User(user.getUserId(), user.getUserName(), user.getEmail(), user.getPassword(), user.isActive(), user.getRole(), user.getCreatedAt());
        return userDao.save(user1);
    }
}
