package com.example.casestudymodule3.servlet;

import com.example.casestudymodule3.model.User;
import com.example.casestudymodule3.service.IUserService;
import com.example.casestudymodule3.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private IUserService iUserService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null){
            action= "";
        }
        switch (action){
            case "show view update user":
                showUpdateUser(req,resp);
                break;
            case "update user":
                updateUser(req,resp);
                break;
            case "delete user":
                removeUser(req,resp);
                break;
            case "show view add user":
                showAddUser(req,resp);
                break;
            case "add user":
                addNewUser(req,resp);
                break;
            default:
                listUser(req,resp);

        }
    }
    private void showUpdateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/updateUser.jsp");
        dispatcher.forward(req, resp);
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("userId");
        if (idString != null && !idString.isEmpty()) {

                int userId = Integer.parseInt(idString);
                User checkId = iUserService.findByID(userId);
                if (checkId != null) {
                    String fullName = req.getParameter("fullName");
                    String dateOfBirthString = req.getParameter("dateOfBirth");
                    String gender = req.getParameter("gender");
                    String address = req.getParameter("address");
                    String phoneNumberString = req.getParameter("phoneNumber");
                    int phoneNumber = Integer.parseInt(phoneNumberString);
                    String email = req.getParameter("email");
                    String password = req.getParameter("password");
                    User updatedUser = new User(userId, fullName, parseDateFromString(dateOfBirthString), gender, address, phoneNumber, email, password);
                    boolean success = iUserService.updateList(updatedUser);

                    if (success) {
                        resp.sendRedirect(req.getContextPath() + "/user?action=list");
                    } else {
                        resp.getWriter().write("Cập nhật người dùng thất bại!");
                    }
                }
        }
    }

    private void removeUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("userId");
        if (idString != null && !idString.isEmpty()) {
            try {
                int id = Integer.parseInt(idString);
                boolean success = iUserService.removeList(id);

                if (success) {
                    resp.sendRedirect(req.getContextPath() + "/user?action=list");
                } else {
                    resp.getWriter().write("Xóa người dùng thất bại!");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write("ID không hợp lệ!");
            }
        }
    }

    private void showAddUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/addUser.jsp");
        dispatcher.forward(req, resp);
    }

    private void addNewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idString = req.getParameter("id");
        int id = 0;
        if (idString != null && !idString.isEmpty()) {
            id = Integer.parseInt(idString);
        }

        String fullName = req.getParameter("full_name");
        String dateOfBirthString = req.getParameter("dateOfBirth");
        if (dateOfBirthString != null && !dateOfBirthString.isEmpty()) {
            Date dateOfBirth = parseDateFromString(dateOfBirthString);
            String gender = req.getParameter("gender");
            String address = req.getParameter("address");
            String phoneNumberString = req.getParameter("phone_number");
            int phoneNumber = Integer.parseInt(phoneNumberString);
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User newUser = new User(id, fullName, dateOfBirth, gender, address, phoneNumber, email, password);
            boolean success = iUserService.addNewList(newUser);
            if (success) {
                resp.sendRedirect(req.getContextPath() + "/user?action=list");
            } else {
                resp.getWriter().write("Thêm người dùng thất bại!");
            }
        } else {
            resp.getWriter().write("Vui lòng nhập ngày sinh hợp lệ!");
        }
    }
    public Date parseDateFromString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = iUserService.getAllList();
        req.setAttribute("users",users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/listUser.jsp");
        dispatcher.forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if ("add user".equals(action)) {
            addNewUser(req, resp);
        } else if ("delete user".equals(action)) {
            removeUser(req, resp);
        } else if ("update user".equals(action)) {
            String idString = req.getParameter("userId");
            if (idString != null && !idString.isEmpty()) {
                try {
                    int userId = Integer.parseInt(idString);
                    updateUser(req, resp);
                } catch (NumberFormatException e) {
                    resp.getWriter().write("ID không hợp lệ!");
                }
            } else {
                resp.getWriter().write("ID không được để trống!");
            }
        }
    }

}
