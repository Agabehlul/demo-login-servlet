<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23.10.2024
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="register.css">
</head>
<body>
<div class="signup-container">
    <form class="signup-form" action="first.jsp" method="POST">
        <h2>Sign Up</h2>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="confirm-password">Confirm Password</label>
            <input type="password" id="confirm-password" name="confirm-password" required>
        </div>
        <button type="submit">Sign Up</button>
        <p class="login-link">Already have an account? <a href="index.jsp">Login</a></p>
    </form>
</div>
</body>
</html>

