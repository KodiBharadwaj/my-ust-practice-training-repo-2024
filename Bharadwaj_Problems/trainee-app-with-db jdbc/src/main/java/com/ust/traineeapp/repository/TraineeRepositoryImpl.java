package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.util.JdbcConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TraineeRepositoryImpl implements TraineeRepository {


    public Trainee save(Trainee trainee) {

        Connection connection = JdbcConnectionUtil.createConnction();
        String sql = "insert into trainee(id,name,location,date_joined) values(?,?,?,?)";


        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, trainee.id());
            statement.setString(2, trainee.name());
            statement.setString(3, trainee.location());
            statement.setDate(4, Date.valueOf(trainee.joinedDate()));
            int rowCount = statement.executeUpdate();
            System.out.println(rowCount + " rows inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return trainee;
    }

    public Trainee getTrainee(int id) {
        Connection connection = JdbcConnectionUtil.createConnction();
        String sql = "select * from trainee where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            Trainee trainee = getTraineeFromResultSet(resultSet);
            return trainee;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Trainee> getAllTrainees() {

        Connection connection = JdbcConnectionUtil.createConnction();

        String sql = "select * from trainee";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Trainee> trainees = getTraineeListFromResultSet(resultSet);
            return trainees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTrainee(int id) {
        Connection connection = JdbcConnectionUtil.createConnction();
        String sql = "delete from trainee where id = ?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Trainee getTraineeFromResultSet(ResultSet resultSet) {
        Trainee trainee = null;
        try {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                LocalDate joinedDate = resultSet.getDate("date_joined").toLocalDate();
                trainee = new Trainee(id, name, location, joinedDate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trainee;
    }

    public List<Trainee> getTraineeListFromResultSet(ResultSet resultSet) {
        List<Trainee> trainees = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                LocalDate joinedDate = resultSet.getDate("date_joined").toLocalDate();
                Trainee trainee = new Trainee(id, name, location, joinedDate);
                trainees.add(trainee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trainees;
    }

}



