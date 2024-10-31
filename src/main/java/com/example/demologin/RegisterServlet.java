package com.example.demologin;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mindrot.jbcrypt.BCrypt.gensalt;

@WebServlet(value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String insertedUsername = request.getParameter("username");
        String insertedPassword = request.getParameter("password");
        String insertedConfirmedPassword = request.getParameter("confirm-password");
        if (!insertedUsername.isBlank() && insertedPassword.equals(insertedConfirmedPassword)) {
            String hashPass = BCrypt.hashpw(insertedPassword, gensalt());
            DbClass db = new DbClass();
            try {
                db.connect();
                PreparedStatement ps = DbClass.CONNECTION
                        .prepareStatement("INSERT INTO matrix.user(username,password,status) values (?,?,?)");
                ps.setString(1, insertedUsername);
                ps.setString(2, hashPass);
                ps.setBoolean(3, true);
                int row = ps.executeUpdate();
                if (row > 0) {
                    System.out.println("successfully added user");
                    response.sendRedirect("index.jsp");
                } else {
                    System.out.println("failed to add user");
                    response.sendRedirect("register.jsp");
                }
                db.disconnect();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("username and password do not match");
            response.sendRedirect("register.jsp");
        }

    }
}
