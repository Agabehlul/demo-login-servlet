<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.07.2025
  Time: 01:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate();
  response.sendRedirect("teacherLogin.jsp");
%>

