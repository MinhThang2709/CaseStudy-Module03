package com.example.casestudymodule3.dao.impl;

import com.example.casestudymodule3.dao.IAccountDAO;
import com.example.casestudymodule3.dao.IUserDAO;
import com.example.casestudymodule3.model.Account;
import com.example.casestudymodule3.model.User;
import com.example.casestudymodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDAO implements IAccountDAO {
    @Override
    public List<Account> getAllAccount() {
        List<Account> accounts = new ArrayList<>();
        try {
            Connection connection = JDBCConnection.getConnection();
            String SELECT_ALL_ACCOUNT = "SELECT * FROM account WHERE is_deleted = 0";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String accountNumber = resultSet.getString("account_number");
                String accountType = resultSet.getString("account_type");
                Double accountBalance = resultSet.getDouble("account_balance");
                Date accountOpeningDate = resultSet.getDate("account_opening_date");
                String accountTerm = resultSet.getString("account_term");

                accounts.add(new Account(id,accountNumber,accountType,accountBalance,accountOpeningDate,accountTerm));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  accounts;
    }

    @Override
    public Account findByID(int id) {
        return null;
    }

    @Override
    public boolean addNewAccount(Account account) {
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }

    @Override
    public boolean removeAccount(int id) {
        return false;
    }
}
