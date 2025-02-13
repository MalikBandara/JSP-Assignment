package org.example.assignment_jsp.BoLayer.BoImpl;

import org.example.assignment_jsp.BoLayer.Bo.UserBo;
import org.example.assignment_jsp.DaoLayer.Dao.UserDao;
import org.example.assignment_jsp.DaoLayer.DaoFactory;
import org.example.assignment_jsp.DaoLayer.DaoType;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBo {


    UserDao userDao = (UserDao) DaoFactory.getDaoFactory().getDao(DaoType.USER);

    @Override
    public boolean SaveUsers(UserDto user) {
        User user1 = new User(user.getUserId(), user.getUserName(), user.getEmail(), user.getPassword(), user.isActive(), user.getRole(), user.getCreatedAt());
        return userDao.save(user1);
    }

    @Override
    public boolean LoginDateails(String email, String password) {
       return userDao.Login(email,password);
    }

    @Override
    public String getUserRole(String email) {
       return userDao.getUserRole(email);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> all = userDao.getAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : all){
            UserDto userDto = new UserDto(user.getUserId(), user.getUserName(), user.getEmail(), user.getPassword(), user.isActive(), user.getRole(), user.getCreatedAt());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserDto getUserId(String userid) {
        User userId = userDao.getUserId(userid);
        UserDto userDto = new UserDto(userId.getUserId(), userId.getUserName(), userId.getEmail(), userId.getPassword(), userId.isActive(), userId.getRole(), userId.getCreatedAt());
        return userDto;


    }
}
