package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> getAllCustomer();
    Customer findByID(int id);
    boolean addNewCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean removeCustomer(int id);
}
