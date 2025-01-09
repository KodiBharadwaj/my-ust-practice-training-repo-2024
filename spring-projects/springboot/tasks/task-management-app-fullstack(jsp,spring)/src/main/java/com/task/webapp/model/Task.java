package com.task.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private String username;
    private String description;
    private LocalDate date;
    private String status;
}
