package com.example.casestudymodule3.service;

import com.example.casestudymodule3.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IUserService extends IUltiService<User>{
    boolean addNewList(User user);
    User findByID(int id);
    List<User> getAllList();
    boolean removeList(int id);
    boolean updateList(User user);
    boolean checkLogin(String phoneNumber, String password);
}
