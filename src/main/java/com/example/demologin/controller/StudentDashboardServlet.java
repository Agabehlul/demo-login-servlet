package com.example.demologin.controller;


import com.example.demologin.dao.ResultDAO;
import com.example.demologin.dao.StudentDAO;
import com.example.demologin.model.Result;
import com.example.demologin.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/student-dashboard")
public class StudentDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("studentId") == null) {
            response.sendRedirect("studentLogin.jsp"); // loginə yönləndir
            return;
        }

        int studentId = (Integer) session.getAttribute("studentId");

        // Tələbə məlumatlarını və nəticələri DB-dən götür
        Student student = StudentDAO.getStudentById(studentId);
        List<Result> results = ResultDAO.getResultsByStudentId(studentId);

        // JSP-yə göndər
        request.setAttribute("student", student);
        request.setAttribute("results", results);
        request.getRequestDispatcher("studentDashboard.jsp").forward(request, response);
    }
}

