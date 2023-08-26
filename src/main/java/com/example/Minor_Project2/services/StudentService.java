package com.example.Minor_Project2.services;


import com.example.Minor_Project2.models.MyUser;
import com.example.Minor_Project2.models.Student;
import com.example.Minor_Project2.repositories.StudentRepository;
import com.example.Minor_Project2.requests.StudentCreateRequest;
import com.example.Minor_Project2.requests.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MyUserDetailsService userDetailsService;

    public void create(StudentCreateRequest studentCreateRequest){

        UserCreateRequest userCreateRequest = studentCreateRequest.toUser();
        MyUser myUser = userDetailsService.createUser(userCreateRequest);

        Student student = studentCreateRequest.to();
        student.setMyUser(myUser);
        studentRepository.save(student);
    }

    public Student findStudentByStudentId(int sId){
        return studentRepository
                .findById(sId).orElse(null);
    }





}
