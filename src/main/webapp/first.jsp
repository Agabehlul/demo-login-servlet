<%@ page import="java.sql.*" %>
<%@ page import="com.example.demologin.DbClass" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "" %></h1>
<br/>
<a href="index.jsp">Login</a>

<%
    DbClass dbClass = new DbClass();
    dbClass.connect();

    if (DbClass.CONNECTION != null) {
        try {
            Statement statement = DbClass.CONNECTION.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM matrix.login");
%>
<table border="solid 1px black">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
    </tr>
    <%
        while (resultSet.next()) {
    %>
    <tr>
        <td><%= resultSet.getInt("id") %></td>
        <td><%= resultSet.getString("name") %></td>
        <td><%= resultSet.getString("surname") %></td>
        <td><%= resultSet.getInt("age") %></td>
    </tr>
    <%   }}catch (Exception e){
    }
    }%>
</table>


</body>
</html>
