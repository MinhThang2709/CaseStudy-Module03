package com.example.casestudymodule3.dao.impl;

import com.example.casestudymodule3.dao.INotificationsDAO;
import com.example.casestudymodule3.model.Notifications;
import com.example.casestudymodule3.utils.JDBCConnection;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationsDAO implements INotificationsDAO {
    @Override
    public List<Notifications> getAllNotifications() {
        List<Notifications> users = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String SELECT_ALL_NOTIFICATIONS = "SELECT * FROM notifications WHERE is_deleted = 0";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NOTIFICATIONS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                int phoneNumber = resultSet.getInt("phone_number");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
//                users.add(new Notifications(id,fullName,dateOfBirth,gender,address,email,password));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  users;
    }

    @Override
    public Notifications findByID(int id) {
        return null;
    }

    @Override
    public boolean addNewNotifications(Notifications notifications) {
        return false;
    }

    @Override
    public boolean updateNotifications(Notifications notifications) {
        return false;
    }

    @Override
    public boolean removeNotifications(int id) {
        return false;
    }
}
