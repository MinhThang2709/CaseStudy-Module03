package com.example.casestudymodule3.service;

import com.example.casestudymodule3.model.Branch;

import java.util.List;

public interface IBranchService extends IUltiService<Branch> {
    boolean addNewList(Branch branch);
    Branch findByID(int id);
    List<Branch> getAllList();
    boolean removeList(int id);
    boolean updateList(Branch branch);
}
