package com.example.casestudymodule3.service;

import com.example.casestudymodule3.model.Transaction;

import java.util.List;

public interface ITransactionService extends IUltiService<Transaction> {
    boolean addNewList(Transaction transaction);
    Transaction findByID(int id);
    List<Transaction> getAllList();
    boolean removeList(int id);
    boolean updateList(Transaction transaction);
}
