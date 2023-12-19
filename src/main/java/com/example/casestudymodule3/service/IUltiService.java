package com.example.casestudymodule3.service;

import com.example.casestudymodule3.model.User;

import java.util.List;

public interface IUltiService <E>{
    List<E> getAllList();
    boolean addNewList(E object);
    E findByID(int id);
    boolean updateList(E object);
    boolean removeList(int id);

}
