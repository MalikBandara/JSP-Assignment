package org.example.assignment_jsp.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.sql.Timestamp;

import static org.example.assignment_jsp.Entity.User.Role.CUSTOMER;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String userName;
    private String Email;
    private String Password;

    private boolean isActive = true;


    @Column(name = "role", nullable = false)
    private String role ;


    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    public enum Role {
        ADMIN, CUSTOMER
    }
}
