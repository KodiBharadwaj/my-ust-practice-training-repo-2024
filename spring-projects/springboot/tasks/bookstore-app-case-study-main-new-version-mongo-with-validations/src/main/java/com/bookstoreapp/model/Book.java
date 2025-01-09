package com.bookstoreapp.model;


import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Book {


    @Id
    private int id;
    // The title should not be empty and should not exceed 100 characters
    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title should not exceed 100 characters")
    private String title;

    // The author should not be empty and should not exceed 200 characters
    @NotBlank(message = "Author is mandatory")
    @Size(max = 200, message = "Author should not exceed 200 characters")
    private String author;

    // The publication year should be a valid year
    @Min(value = 1000, message = "Publication year should be a valid year")
    @Max(value = 2024, message = "Publication year should be a valid year")
    private int publicationYear;

    // The ISBN should be a valid 10- or 13-digit number.

    private long isbn;

    // The price should be a positive decimal value.
    @Positive
    private double price;

}
