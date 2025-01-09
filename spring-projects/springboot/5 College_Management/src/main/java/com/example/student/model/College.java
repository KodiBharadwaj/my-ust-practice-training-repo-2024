package com.example.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PublicKey;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {

    @Id
    private long id;
    private String name;

    @OneToMany(mappedBy = "college")
    @JsonIgnore
    private List<Student> students;

}
