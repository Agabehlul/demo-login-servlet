<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.07.2025
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/indexStylee.css">
</head>
<body>
<div class="login-container">
    <form class="login-form" action="LoginServlet" method="POST">
        <h2>Login</h2>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Login</button>
        <p class="signup-link">Don't have an account? <a href="register.jsp">Sign up</a></p>
    </form>
</div>
</body>

</html>
