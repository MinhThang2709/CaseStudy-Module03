package com.example.casestudymodule3.service.impl;

import com.example.casestudymodule3.dao.ITransactionDAO;
import com.example.casestudymodule3.dao.impl.TransactionDAO;
import com.example.casestudymodule3.model.Transaction;
import com.example.casestudymodule3.service.ITransactionService;

import java.util.List;

public class TransactionService implements ITransactionService {
    private ITransactionDAO iTransactionDAO = new TransactionDAO();

    @Override
    public boolean addNewList(Transaction transaction) {
        return false;
    }

    @Override
    public Transaction findByID(int id) {
        return null;
    }

    @Override
    public List<Transaction> getAllList() {
        return iTransactionDAO.getAllTransaction();
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }

    @Override
    public boolean updateList(Transaction transaction) {
        return false;
    }
}
