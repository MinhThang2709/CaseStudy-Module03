<%--
  Created by IntelliJ IDEA.
  User: Moderator
  Date: 10/9/2023
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Thêm Người Dùng Mới</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffe4e1;
        }

        h1 {
            color: #ff1493;
        }

        form {
            background-color: #fff5ee;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin: 0 auto;
        }

        label {
            color: #ff69b4;
            font-weight: bold;
        }

        input[type="text"],
        input[type="date"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ff69b4;
            border-radius: 5px;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        button[type="submit"] {
            background-color: #ff69b4;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #ff1493;
        }
    </style>

</head>
<body>
<h1>Thêm Người Dùng Mới</h1>
<form action="${pageContext.request.contextPath}/user?action=add user" method="post">
    <input type="hidden" name="id" value="">

    <%--@declare id="gender"--%><label for="full_name">Họ và tên:</label>
    <input type="text" id="full_name" name="full_name" placeholder="Họ và tên" required><br><br>

    <label for="dateOfBirth">Ngày sinh:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" required><br><br>

    <label for="gender">Giới Tính:</label>
    <input type="text" id="gender" name="gender" value="${userToEdit.gender}" required><br>

    <label for="address">Địa chỉ:</label>
    <input type="text" id="address" name="address" placeholder="Địa chỉ" required><br><br>

    <label for="phone_number">Số điện thoại:</label>
    <input type="text" id="phone_number" name="phone_number" placeholder="Số điện thoại" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" placeholder="Email" required><br><br>

    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" placeholder="Mật khẩu" required><br><br>

    <button type="submit">Thêm</button>
</form>
</body>
</html>
