package com.demo_app.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user_db")
public class User {
    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name", length = 100)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
