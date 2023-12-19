package com.example.casestudymodule3.service.impl;

import com.example.casestudymodule3.dao.IAccountDAO;
import com.example.casestudymodule3.dao.impl.AccountDAO;
import com.example.casestudymodule3.model.Account;
import com.example.casestudymodule3.service.IAccountService;

import java.util.List;

public class AccountService implements IAccountService {
    private IAccountDAO iAccountDAO = new AccountDAO();

    @Override
    public List<Account> getAllList() {
        return iAccountDAO.getAllAccount();
    }


    @Override
    public boolean addNewList(Account account) {
        return false;
    }

    @Override
    public Account findByID(int id) {
        return null;
    }



    @Override
    public boolean removeList(int id) {
        return false;
    }

    @Override
    public boolean updateList(Account account) {
        return false;
    }
}
