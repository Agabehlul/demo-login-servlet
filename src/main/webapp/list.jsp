<%@ page import="java.sql.*" %>
<%@ page import="com.example.demologin.DbClass" %>
<%@ page import="com.example.demologin.User" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style><%@include file="register.css" %></style>
</head>
<body>
<h1><%= "" %>
</h1>
<br/>
<%
    String name = null;
    Cookie[] cookies = request.getCookies();
    for(Cookie cookie : cookies) {
        if(cookie.getName().equals("username"))
            name = cookie.getValue();
    }
%>
<a href=""><span style="border: 2px solid #ccc; padding: 5px; border-radius: 3px;">User: <%= name %></span></a>
<a style="margin-left: 85%" href="${pageContext.request.contextPath}/LogoutServlet"><button>Log out</button></a>


<%
    HttpSession httpSession = request.getSession(false);
    System.out.println(httpSession);
    Boolean logged = (Boolean) httpSession.getAttribute("login");
    if (logged != null && logged) {
        DbClass dbClass = new DbClass();
        dbClass.connect();

        if (DbClass.CONNECTION != null) {
            try {
                Statement statement = DbClass.CONNECTION.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM matrix.user");
%>
<table border="solid 1px black">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Status</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <%
        while (resultSet.next()) {
    %>
    <tr>
        <td><%= resultSet.getInt("id") %></td>
        <td><%= resultSet.getString("username") %>
        <td><%= resultSet.getBoolean("status") %></td>
        <td><a href="#" onClick="confirmDelete(<%= resultSet.getInt("id") %>)">Delete</a></td>
        <td><a href="" onClick="confirmEdit(<%= resultSet.getInt("id") %>)">Edit</a></td>
    </tr>
    <% }
    } catch (Exception e) {
    }
    }
    %>
</table>
<!-- Edit Form -->



<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>
<script>
    function confirmDelete(id) {
        var isConfirmed = confirm("confirm delete");
        if (isConfirmed) {
            window.location.href = "DeleteServlet?id=" + id;
        } else {
            window.location.href = "list.jsp";
        }
    }
</script>
<script>
    function confirmEdit(id) {

        document.getElementById('editId').value = id;


        var username = prompt("Enter new username:");
        if (username) {
            document.getElementById('editUsername').value = username;
        } else {
            alert("Username cannot be empty.");
            return;
        }


        var password = prompt("Enter new password:");
        if (password) {
            document.getElementById('editPassword').value = password;
        } else {
            alert("Password cannot be empty.");
            return;
        }
        document.getElementById('editForm').submit();
    }
</script>

<!-- Edit Form -->
<form id="editForm" method="post" action="UpdateServlet">
    <input type="hidden" id="editId" name="id">
    <input type="hidden" id="editUsername" name="username">
    <input type="hidden" id="editPassword" name="password">
</form>


<footer style="background-color: #f1f1f1; padding: 20px; text-align: center; font-size: 14px; color: #666;">
    <p>&copy; 2024 Agabehlul. All rights reserved.</p>
</footer>
</body>

</html>