package com.example.Minor_Project2.requests;

import com.example.Minor_Project2.models.Admin;
import com.example.Minor_Project2.models.Student;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequest {


    private String username;

    private String password;

    private String authority;

    private Student student;

    private Admin admin;



}
