package com.example.casestudymodule3.service;

import com.example.casestudymodule3.model.Account;

import java.util.List;

public interface IAccountService extends IUltiService<Account>{
    boolean addNewList(Account account);
    Account findByID(int id);
    List<Account> getAllList();
    boolean removeList(int id);
    boolean updateList(Account account);
}
