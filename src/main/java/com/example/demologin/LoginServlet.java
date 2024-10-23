package com.example.demologin;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet",value = "/loginServlet")
public class LoginServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DbClass db = new DbClass();
        try {
            db.connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
