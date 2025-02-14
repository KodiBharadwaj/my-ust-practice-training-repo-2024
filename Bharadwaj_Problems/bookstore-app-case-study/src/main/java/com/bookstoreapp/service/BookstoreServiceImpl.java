package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.repository.BookRepositoryImpl;
import com.bookstoreapp.util.JdbcConnectionUtil;


import javax.swing.text.html.Option;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BookstoreServiceImpl implements BookstoreService{


    private BookRepository bookRepository=new BookRepositoryImpl();

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        // check if book exists
        // if book exists return book
        // else throw exception book not found
        Optional<Book>res= bookRepository.findById(id);
        return res.orElseThrow(() -> new BookNotFoundException("Book not found"));
    }

    @Override
    public Book saveBook(Book book) {
        if(!bookRepository.findById(book.getId()).equals(Optional.empty())){
            throw new BookAlreadyExistsException("Book already exists");
        }

        // check if book exists
        // if book exists throw exception book already exists
        // else save book

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(int id, Book book) {

        // check if book exists
        // if book exists update book
        // else throw exception book not found

        if(bookRepository.findById(id).equals(Optional.empty())){
            throw new BookNotFoundException("Book not found");
        }

        return bookRepository.update(book);

    }

    @Override
    public void deleteBook(int id) {

            // check if book exists
            // if book exists delete book
            // else throw exception book not found
        if(bookRepository.findById(id).equals(Optional.empty())){
            throw new BookNotFoundException("Book Not found");
        }
        bookRepository.deleteById(id);
    }


}
