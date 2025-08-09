//package com.example.demologin.controller;
//
//import com.example.demologin.dao.QuizDAO;
//import com.example.demologin.model.Quiz;
//import com.example.demologin.util.DbClass;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//@WebServlet("/CreateQuizServlet")
//public class CreateQuizServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // Form məlumatlarını al
//        String title = request.getParameter("title");
//        int grade = Integer.parseInt(request.getParameter("grade"));
//
//        // Yeni quiz obyekti yarat
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setGrade(grade);
//
//        DbClass db = new DbClass();
//        try {
//            db.connect();
//            Connection conn = DbClass.CONNECTION;
//
//            QuizDAO quizDAO = new QuizDAO(conn);
//            boolean success = quizDAO.createQuiz(quiz);
//
//            if (success) {
//                response.sendRedirect("teacherDashboard.jsp?success=1");
//            } else {
//                response.sendRedirect("createQuiz.jsp?error=1");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendRedirect("createQuiz.jsp?error=2");
//        } finally {
//            db.disconnect();
//        }
//    }
//}
