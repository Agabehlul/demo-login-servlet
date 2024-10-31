package com.example.demologin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        boolean login = (session != null && session.getAttribute("login") != null);
        if (login && request.getParameter("id") != null) {
            String idString = request.getParameter("id");
            int id = Integer.parseInt(idString);
            DbClass db = new DbClass();
            try {
                db.connect();
                Connection conn = DbClass.CONNECTION;
                String sql = "DELETE FROM matrix.user WHERE id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("User deleted successfully!");
                } else {
                    System.out.println("No user found with the specified ID.");
                }
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                db.disconnect();
                request.getRequestDispatcher("first.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("first.jsp");
        }
    }
}
