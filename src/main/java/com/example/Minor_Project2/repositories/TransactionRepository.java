package com.example.Minor_Project2.repositories;


import com.example.Minor_Project2.models.Book;
import com.example.Minor_Project2.models.Student;
import com.example.Minor_Project2.models.Transaction;
import com.example.Minor_Project2.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(
            Book book, Student student, TransactionType transactionType
    );

}