package com.example.casestudymodule3.servlet;

import com.example.casestudymodule3.service.IUserService;
import com.example.casestudymodule3.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/adminlogin")


public class AdminLoginServlet extends HttpServlet {
    private IUserService iUserService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher dispatcher = req.getRequestDispatcher("admin-login/loginadmin.jsp");
        dispatcher.forward(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        if (iUserService.checkLogin(phoneNumber, password)) {
            response.sendRedirect(request.getContextPath() + "/user?action=list");
        } else {
            response.sendRedirect(request.getContextPath() + "admin-login/loginadmin.jsp");
        }
    }
}
