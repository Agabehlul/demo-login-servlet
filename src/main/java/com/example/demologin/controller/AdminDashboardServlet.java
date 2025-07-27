package com.example.demologin.controller;

import com.example.demologin.dao.StudentDAO;
import com.example.demologin.dao.TeacherDAO;
import com.example.demologin.model.Student;
import com.example.demologin.model.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        TeacherDAO teacherDAO = new TeacherDAO();

        List<Student> students = studentDAO.getAllStudents();
        List<Teacher> teachers = teacherDAO.getAllTeachers();

        request.setAttribute("studentList", students);
        request.setAttribute("teacherList", teachers);

        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}
