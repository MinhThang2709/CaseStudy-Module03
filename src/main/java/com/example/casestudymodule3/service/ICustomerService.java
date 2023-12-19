package com.example.casestudymodule3.service;

import com.example.casestudymodule3.model.Customer;

import java.util.List;

public interface ICustomerService extends IUltiService<Customer>{
    boolean addNewList(Customer customer);
    Customer findByID(int id);
    List<Customer> getAllList();
    boolean removeList(int id);
    boolean updateList(Customer customer);

}
