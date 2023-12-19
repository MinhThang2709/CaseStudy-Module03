package com.example.casestudymodule3.service.impl;

import com.example.casestudymodule3.dao.ICustomerDAO;
import com.example.casestudymodule3.dao.impl.CustomerDAO;
import com.example.casestudymodule3.model.Customer;
import com.example.casestudymodule3.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerDAO iCustomerDAO = new CustomerDAO();
    @Override
    public boolean addNewList(Customer customer) {
        return false;
    }

    @Override
    public Customer findByID(int id) {
        return null;
    }

    @Override
    public List<Customer> getAllList() {
        return iCustomerDAO.getAllCustomer();
    }

    @Override
    public boolean removeList(int id) {
        return false;
    }

    @Override
    public boolean updateList(Customer customer) {
        return false;
    }
}
