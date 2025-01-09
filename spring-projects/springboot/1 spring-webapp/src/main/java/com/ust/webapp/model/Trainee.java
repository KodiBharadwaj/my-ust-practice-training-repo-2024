package com.ust.webapp.model;

//public record Trainee(int id, String name, String location) {
//}

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {
    private int id;
    private String name;
    private String location;
}