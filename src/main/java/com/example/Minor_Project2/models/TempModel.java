package com.example.Minor_Project2.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TempModel implements Serializable {

    @Id
    private int id;
    @Id
    private String name;

    @CreationTimestamp
    private Date createdOn;

//    @OneToMany(mappedBy = "tempModel")
//    private List<Book> bookList;

}