package com.example.casestudymodule3.servlet;

import com.example.casestudymodule3.model.Account;

import com.example.casestudymodule3.service.IAccountService;
import com.example.casestudymodule3.service.impl.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountServlet", value = "/account")

public class AccountServlet extends HttpServlet {
    private IAccountService iAccountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action= "";
        }
        switch (action){
            case "show view update account":
                showUpdateAccount(req,resp);
                break;
            case "update account":
                updateAccount(req,resp);
                break;
            case "delete account":
                removeAccount(req,resp);
                break;
            case "show view add account":
                showAddAccount(req,resp);
                break;
            case "add account":
                addNewAccount(req,resp);
                break;
            default:
                listAccount(req,resp);

        }
    }

    private void listAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> accounts = iAccountService.getAllList();
        req.setAttribute("accounts",accounts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("account/listAccount.jsp");
        dispatcher.forward(req,resp);
    }

    private void addNewAccount(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showAddAccount(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void removeAccount(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void updateAccount(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showUpdateAccount(HttpServletRequest req, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("add account".equals(action)) {
            addNewAccount(req, resp);
        } else if ("delete account".equals(action)) {
            removeAccount(req, resp);
        } else if ("update account".equals(action)) {
            String idString = req.getParameter("accountId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int accountId = Integer.parseInt(idString);
                    updateAccount(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }
}
