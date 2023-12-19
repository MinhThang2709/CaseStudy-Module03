package com.example.casestudymodule3.dao.impl;

import com.example.casestudymodule3.dao.IUserDAO;
import com.example.casestudymodule3.model.User;
import com.example.casestudymodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO implements IUserDAO {
    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String SELECT_ALL_USER = "SELECT * FROM user WHERE is_deleted = 0";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                int phoneNumber = resultSet.getInt("phone_number");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                users.add(new User(id,fullName,dateOfBirth,gender,address,phoneNumber,email,password));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  users;
    }


    @Override
    public User findByID(int id) {
        String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ? AND is_deleted = 0";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                int phoneNumber = resultSet.getInt("phone_number");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(id, fullName, dateOfBirth, gender, address, phoneNumber, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addNewUser(User user) {
        String INSERT_USER = "INSERT INTO user (full_name, date_of_birth, gender, address, phone_number, email, password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1,user.getFullName());
            preparedStatement.setDate(2,new java.sql.Date(user.getDateOfBirth().getTime()));
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4,user.getAddress());
            preparedStatement.setInt(5,user.getPhoneNumber());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7,user.getPassword());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateUser(User user) {
        String UPDATE_USER = "UPDATE user SET full_name = ?, date_of_birth = ?, gender = ?, address = ?, phone_number = ?, email = ?, password = ? WHERE id = ?";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setDate(2, new java.sql.Date(user.getDateOfBirth().getTime()));
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setInt(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setInt(8, user.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean removeUser(int id) {
        String UPDATE_USER_STATUS = "UPDATE user SET is_deleted = 1 WHERE id = ?";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_STATUS)) {
            preparedStatement.setInt(1, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User findByPhoneNumber(int phoneNumber) {
        String SELECT_USER_BY_PHONE = "SELECT * FROM user WHERE phone_number = ? AND is_deleted = 0";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_PHONE)) {
            preparedStatement.setInt(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(id, fullName, dateOfBirth, gender, address, phoneNumber, email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


