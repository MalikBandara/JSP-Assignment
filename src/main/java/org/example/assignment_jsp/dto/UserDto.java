package org.example.assignment_jsp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int userId;
    private String userName;
    private String Email;
    private String Password;
    private boolean isActive = true;
    private String role ;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
}
