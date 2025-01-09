package com.bookstoreapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {


    @Id
    @Column(name = "table_id")
    private int id;
    // The title should not be empty and should not exceed 100 characters
    @Column
    private String title;

    // The author should not be empty and should not exceed 200 characters
    @Column
    private String author;

    // The publication year should be a valid year
    @Column
    private int publicationYear;

    // The ISBN should be a valid 10- or 13-digit number.
    @Column
    private long isbn;

    // The price should be a positive decimal value.
    @Column
    private double price;

}
