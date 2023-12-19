package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.User;

import java.util.List;

public interface IUserDAO {
    List<User> getAllUser();
    User findByID(int id);
    boolean addNewUser(User user);
    boolean updateUser(User user);
    boolean removeUser(int id);
    User findByPhoneNumber(int phoneNumber);
}
