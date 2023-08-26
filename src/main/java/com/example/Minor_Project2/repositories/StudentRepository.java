package com.example.Minor_Project2.repositories;


import com.example.Minor_Project2.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository  -- Not mandatory because SimpleJPARepository class has a repository annotation
public interface StudentRepository extends JpaRepository<Student, Integer> {
}


