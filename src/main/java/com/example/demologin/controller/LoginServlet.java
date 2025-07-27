package com.example.demologin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("login", true);
            session.setAttribute("username", username);
            session.setAttribute("role", "admin");

            response.sendRedirect("adminDashboard.jsp");
        } else {
            // Səhv olduqda error parametri ilə redirect
            response.sendRedirect("adminLogin.jsp?error=1");
        }
    }
}
