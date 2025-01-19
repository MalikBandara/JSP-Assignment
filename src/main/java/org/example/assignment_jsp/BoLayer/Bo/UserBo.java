package org.example.assignment_jsp.BoLayer.Bo;

import org.example.assignment_jsp.BoLayer.SuperBo;
import org.example.assignment_jsp.Entity.User;

public interface UserBo extends SuperBo {
    boolean SaveUsers(User user);
}
