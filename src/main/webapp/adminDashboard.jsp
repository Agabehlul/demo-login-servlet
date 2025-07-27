<%@ page import="java.sql.*" %>
<%@ page import="com.example.demologin.util.DbClass" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
    <style>
        table { border-collapse: collapse; width: 100%; margin-bottom: 30px; }
        th, td { border: 1px solid #aaa; padding: 10px; text-align: left; }
        th { background-color: #f5f5f5; }
        h2 { margin-top: 50px; }
    </style>
</head>
<body>
<%
    // Burada "HttpSession session" yazmıram, çünki implicit dəyişən var
    if (session == null || session.getAttribute("login") == null || !(Boolean) session.getAttribute("login")) {
        response.sendRedirect("adminLogin.jsp");
        return;
    }
%>

<h1>Admin Panel</h1>

<%
    DbClass dbClass = new DbClass();
    try {
        dbClass.connect();
        Connection conn = DbClass.CONNECTION;

        // Şagirdlər
        try (Statement studentStmt = conn.createStatement();
             ResultSet studentRs = studentStmt.executeQuery("SELECT * FROM students")) {
%>

<h2>Qeydiyyatdan keçmiş Şagirdlər</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Ad</th>
        <th>Soyad</th>
        <th>Ata adı</th>
        <th>Sinif</th>
        <th>Username</th>
    </tr>
    <%
        while(studentRs.next()) {
    %>
    <tr>
        <td><%= studentRs.getInt("id") %></td>
        <td><%= studentRs.getString("name") %></td>
        <td><%= studentRs.getString("surname") %></td>
        <td><%= studentRs.getString("father_name") %></td>
        <td><%= studentRs.getString("grade") %></td>
        <td><%= studentRs.getString("username") %></td>
    </tr>
    <% } %>
</table>

<%
    }

    // Müəllimlər
    try (Statement teacherStmt = conn.createStatement();
         ResultSet teacherRs = teacherStmt.executeQuery("SELECT * FROM teachers")) {
%>

<h2>Müəllimlər</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Ad Soyad</th>
        <th>Username</th>
    </tr>
    <%
        while(teacherRs.next()) {
    %>
    <tr>
        <td><%= teacherRs.getInt("id") %></td>
        <td><%= teacherRs.getString("full_name") %></td>
        <td><%= teacherRs.getString("username") %></td>
    </tr>
    <% } %>
</table>

<%
    }
} catch (Exception e) {
%>
<p style='color:red;'>Xəta baş verdi: <%= e.getMessage() %></p>
<%
    } finally {
        dbClass.disconnect();
    }
%>

</body>
</html>
