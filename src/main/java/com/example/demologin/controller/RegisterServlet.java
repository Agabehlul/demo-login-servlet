package com.example.demologin.controller;

import com.example.demologin.util.DbClass;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String surname = request.getParameter("surname").trim();
        String fatherName = request.getParameter("fatherName").trim();
        String gradeStr = request.getParameter("grade").trim();
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Sadə yoxlamalar
        if (name.isEmpty() || surname.isEmpty() || fatherName.isEmpty() ||
                gradeStr.isEmpty() || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Bütün sahələr doldurulmalıdır!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Parollar uyğun gəlmir!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        int grade;
        try {
            grade = Integer.parseInt(gradeStr);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Sinif rəqəmlə olmalıdır!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        DbClass db = new DbClass();

        try {
            db.connect();
            PreparedStatement ps = DbClass.CONNECTION.prepareStatement(
                    "INSERT INTO students (name, surname, father_name, grade, username, password) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, fatherName);
            ps.setInt(4, grade);
            ps.setString(5, username);
            ps.setString(6, hashedPassword);
//            ps.setBoolean(7, true);

            int affectedRows = ps.executeUpdate();
            db.disconnect();

            if (affectedRows > 0) {
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("errorMessage", "Qeydiyyat zamanı xəta baş verdi.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Verilənlər bazası xətası: " + e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
