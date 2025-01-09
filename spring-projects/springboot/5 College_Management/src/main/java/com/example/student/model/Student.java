package com.example.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private long id;
    private String name;
    private String courseTaken;
    private int marks;

    @ManyToOne
    private College college;

}
