package com.bookstoreapp.model;

public class Book {

    private int id;
    // The title should not be empty and should not exceed 100 characters
    private String title;

    // The author should not be empty and should not exceed 200 characters
    private String author;

    // The publication year should be a valid year
    private int publicationYear;

    // The ISBN should be a valid 10- or 13-digit number.
    private long isbn;

    // The price should be a positive decimal value.
    private double price;

    public Book(int id, String title, String author, int publicationYear, long isbn, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", isbn=" + isbn +
                ", price=" + price +
                '}';
    }
}
