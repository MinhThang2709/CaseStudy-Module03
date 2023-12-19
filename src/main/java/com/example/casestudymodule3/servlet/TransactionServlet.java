package com.example.casestudymodule3.servlet;

import com.example.casestudymodule3.model.Transaction;
import com.example.casestudymodule3.service.ITransactionService;
import com.example.casestudymodule3.service.impl.TransactionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TransactionServlet", value = "/transaction")

public class TransactionServlet extends HttpServlet {
    private ITransactionService iTransactionService = new TransactionService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action= "";
        }
        switch (action){
            case "show view update user":
                showUpdateTransaction(req,resp);
                break;
            case "update user":
                updateTransaction(req,resp);
                break;
            case "delete user":
                removeTransaction(req,resp);
                break;
            case "show view add user":
                showAddTransaction(req,resp);
                break;
            case "add user":
                addNewTransaction(req,resp);
                break;
            default:
                listTransaction(req,resp);

        }
    }

    private void listTransaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Transaction> transactions = iTransactionService.getAllList();
        req.setAttribute("transactions",transactions);
        RequestDispatcher dispatcher = req.getRequestDispatcher("transaction/listTransaction.jsp");
        dispatcher.forward(req,resp);
    }

    private void addNewTransaction(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showAddTransaction(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void removeTransaction(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void updateTransaction(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showUpdateTransaction(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("add transaction".equals(action)) {
            addNewTransaction(req, resp);
        } else if ("delete transaction".equals(action)) {
            removeTransaction(req, resp);
        } else if ("update transaction".equals(action)) {
            String idString = req.getParameter("transactionId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int transactionId = Integer.parseInt(idString);
                    updateTransaction(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }
    }

