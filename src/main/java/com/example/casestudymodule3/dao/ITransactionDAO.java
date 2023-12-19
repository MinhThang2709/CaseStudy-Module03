package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.Transaction;

import java.util.List;

public interface ITransactionDAO {
    List<Transaction> getAllTransaction();
    Transaction findByID(int id);
    boolean addNewTransaction(Transaction user);
    boolean updateTransaction(Transaction user);
    boolean removeTransaction(int id);
}
