package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.Branch;

import java.util.List;

public interface IBranchDAO {
    List<Branch> getAllBranch();
    Branch findByID(int id);
    boolean addNewBranch(Branch branch);
    boolean updateBranch(Branch branch);
    boolean removeBranch(int id);
}
