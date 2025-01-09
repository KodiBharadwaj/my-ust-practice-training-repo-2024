package com.bookstoreapp.repository;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.util.JdbcConnectionUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    @Override
    public List<Book> findAll() {
        Connection connection = JdbcConnectionUtil.createConnection();
        String sql = "select * from book";
        List<Book> bookList = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id1 = resultSet.getInt("id");
                String title1 = resultSet.getString("title");
                String author1 = resultSet.getString("author");
                int publicationYear = resultSet.getInt("publication_year");
                long isbn1 = resultSet.getLong("isbn");
                double price1 = resultSet.getDouble("price");

                Book book = new Book(id1, title1, author1, publicationYear, isbn1, price1);
                bookList.add(book);
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

        return bookList;
    }

    @Override
    public Optional<Book> findById(int id) {
        Connection connection = JdbcConnectionUtil.createConnection();
        String sql = "select * from book where id = ?";
        Book book = null;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                int id1 = resultSet.getInt("id");
                String title1 = resultSet.getString("title");
                String author1 = resultSet.getString("author");
                int publicationYear = resultSet.getInt("publication_year");
                long isbn1 = resultSet.getLong("isbn");
                double price1 = resultSet.getDouble("price");

                book = new Book(id1, title1, author1, publicationYear, isbn1, price1);
                return Optional.of(book);

            }
            return Optional.empty();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book save(Book book) {


        Connection connection = JdbcConnectionUtil.createConnection();
        String sql = "insert into book(id,title,author,publication_year,isbn,price) values(?,?,?,?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getPublicationYear());
            statement.setLong(5, book.getIsbn());
            statement.setDouble(6, book.getPrice());
            int rowCount = statement.executeUpdate();
            System.out.println(rowCount + " rows inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return book;
    }

    @Override
    public void deleteById(int id) {

        Connection connection = JdbcConnectionUtil.createConnection();
        String sql = "delete from book where id = ?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book update(Book book) {

        Connection connection = JdbcConnectionUtil.createConnection();
        String sql = "update book set title = ?, author = ?, publication_year = ?, isbn = ?, price =?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getPublicationYear());
            statement.setLong(4, book.getIsbn());
            statement.setDouble(5, book.getPrice());
            statement.executeUpdate();
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
