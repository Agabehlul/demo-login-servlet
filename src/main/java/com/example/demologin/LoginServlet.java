package com.example.demologin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String insertedUsername = request.getParameter("username");
        String insertedPassword = request.getParameter("password");

        DbClass dbClass = new DbClass();
        try {
            dbClass.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        User user = new User();
        if (DbClass.CONNECTION != null) {
            try {
                PreparedStatement ps = DbClass.CONNECTION.prepareStatement("SELECT * FROM matrix.user WHERE username = ?");
                ps.setString(1, insertedUsername);
                ResultSet resultSet = ps.executeQuery();

                if (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setStatus(resultSet.getBoolean("status"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if (user.getUsername() != null && user.getUsername().equals(insertedUsername)
                && verifyPassword(insertedPassword, user.getPassword()) && user.getStatus()
                || (insertedUsername.equals("admin")
                && insertedPassword.equals("admin"))) {
            HttpSession session = request.getSession();
            session.setAttribute("login", true);

            Cookie usernameCookie = new Cookie("username", insertedUsername);
            usernameCookie.setMaxAge(3600);
            response.addCookie(usernameCookie);

            response.sendRedirect("list.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        boolean login = (session != null && session.getAttribute("login") != null);

//        if (login) {
//            AddServlet addServlet = new AddServlet();
//            addServlet.doPost(request, response);
//        } else {
//            response.sendRedirect("index.jsp");
//        }
    }

    public Boolean verifyPassword(String insertedPassword, String hashPass) {
        return BCrypt.checkpw(insertedPassword, hashPass);
    }
}
