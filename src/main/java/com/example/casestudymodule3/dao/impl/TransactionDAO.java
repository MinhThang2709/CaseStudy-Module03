package com.example.casestudymodule3.dao.impl;

import com.example.casestudymodule3.dao.ITransactionDAO;
import com.example.casestudymodule3.model.Transaction;
import com.example.casestudymodule3.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements ITransactionDAO {
    @Override
    public List<Transaction> getAllTransaction() {
        List<Transaction> transactions = new ArrayList<>();

        try {
            Connection connection = JDBCConnection.getConnection();
            String SELECT_ALL_TRANSACTION = "SELECT * FROM transaction WHERE is_deleted = 0";
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSACTION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                double amount = resultSet.getDouble("amount");
                double balanceAfterTransaction = resultSet.getDouble("balance_after_transaction");
                String transactionTime = resultSet.getString("transaction_time");
                String address = resultSet.getString("address");
                transactions.add(new Transaction(id,amount,balanceAfterTransaction,transactionTime,address));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  transactions;
    }

    @Override
    public Transaction findByID(int id) {
        return null;
    }

    @Override
    public boolean addNewTransaction(Transaction user) {
        return false;
    }

    @Override
    public boolean updateTransaction(Transaction user) {
        return false;
    }

    @Override
    public boolean removeTransaction(int id) {
        return false;
    }
}
