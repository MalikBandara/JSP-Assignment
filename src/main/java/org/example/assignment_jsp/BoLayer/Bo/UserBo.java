package org.example.assignment_jsp.BoLayer.Bo;

import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.Entity.User;
import org.example.assignment_jsp.dto.UserDto;

public interface UserBo extends SuperBo {
    boolean SaveUsers(UserDto user);

    boolean LoginDateails(String email, String password);

    public String getUserRole(String email);

}
