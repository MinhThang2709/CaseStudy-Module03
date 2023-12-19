package com.example.casestudymodule3.service.impl;

import com.example.casestudymodule3.dao.IUserDAO;
import com.example.casestudymodule3.dao.impl.UserDAO;
import com.example.casestudymodule3.model.User;
import com.example.casestudymodule3.service.IUltiService;
import com.example.casestudymodule3.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserDAO iUserDao = new UserDAO();


    @Override
    public List<User> getAllList() {
        return iUserDao.getAllUser();
    }

    @Override
    public boolean updateList(User user) {
        return iUserDao.updateUser(user);
    }

    @Override
    public boolean checkLogin(String phoneNumber, String password) {
        User user = iUserDao.findByPhoneNumber(Integer.parseInt(phoneNumber));
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean removeList(int id) {
        return iUserDao.removeUser(id);
    }

    @Override
    public boolean addNewList(User user) {
        return iUserDao.addNewUser(user);
    }

    @Override
    public User findByID(int id) {
        return iUserDao.findByID(id);
    }
}
