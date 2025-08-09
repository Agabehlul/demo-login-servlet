package com.example.demologin.controller;

import com.example.demologin.util.DbClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String insertedUsername = request.getParameter("username").trim();
        String insertedPassword = request.getParameter("password");

        if (insertedUsername.isEmpty() || insertedPassword.isEmpty()) {
            request.setAttribute("errorMessage", "İstifadəçi adı və şifrə boş ola bilməz!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        DbClass db = new DbClass();

        try {
            db.connect();

            PreparedStatement ps = DbClass.CONNECTION.prepareStatement("SELECT * FROM students WHERE username = ?");
            ps.setString(1, insertedUsername);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");

                if (BCrypt.checkpw(insertedPassword, hashedPassword)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("login", true);
                    session.setAttribute("username", insertedUsername);
                    session.setAttribute("studentId", rs.getInt("id"));
                    session.setAttribute("name", rs.getString("name"));
                    session.setAttribute("surname", rs.getString("surname"));

                    response.sendRedirect("studentDashboard.jsp");
                } else {
                    request.setAttribute("errorMessage", "İstifadəçi adı və ya şifrə səhvdir!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "İstifadəçi adı və ya şifrə səhvdir!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            db.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Verilənlər bazası xətası: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}

