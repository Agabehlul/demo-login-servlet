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

@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String insertedUsername = request.getParameter("username");
        String insertedPassword = request.getParameter("password");

        if (insertedUsername == null || insertedUsername.trim().isEmpty() || insertedPassword == null || insertedPassword.isEmpty()) {
            request.setAttribute("errorMessage", "İstifadəçi adı və şifrə boş ola bilməz!");
            request.getRequestDispatcher("teacherLogin.jsp").forward(request, response);
            return;
        }

        DbClass db = new DbClass();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            db.connect();

            ps = DbClass.CONNECTION.prepareStatement(
                    "SELECT * FROM teachers WHERE username = ?"
            );
            ps.setString(1, insertedUsername.trim());

            rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");

                if (insertedPassword.equals(hashedPassword)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("login", true);
                    session.setAttribute("role", "teacher");
                    session.setAttribute("username", insertedUsername.trim());
                    session.setAttribute("teacherId", rs.getInt("id"));
                    session.setAttribute("fullName", rs.getString("full_name"));

                    response.sendRedirect("teacherDashboard.jsp");
                } else {
                    request.setAttribute("errorMessage", "İstifadəçi adı və ya şifrə səhvdir!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "İstifadəçi adı və ya şifrə səhvdir!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Verilənlər bazası xətası: " + e.getMessage());
            request.getRequestDispatcher("teacherLogin.jsp").forward(request, response);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                db.disconnect();
            } catch (SQLException ignored) {
            }
        }
    }
}
