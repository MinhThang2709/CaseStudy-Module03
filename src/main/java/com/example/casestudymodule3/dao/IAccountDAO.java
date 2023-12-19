package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.Account;
import com.example.casestudymodule3.model.User;

import java.util.List;

public interface IAccountDAO {
    List<Account> getAllAccount();
    Account findByID(int id);
    boolean addNewAccount(Account account);
    boolean updateAccount(Account account);
    boolean removeAccount(int id);
}
