package com.example.demologin.controller;

import com.example.demologin.dao.QuestionDAO;
import com.example.demologin.model.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet {

    private QuestionDAO questionDAO;

    @Override
    public void init() throws ServletException {
        questionDAO = new QuestionDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // formdan məlumatları al
        String questionText = request.getParameter("questionText");
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        String option4 = request.getParameter("option4");
        String option5 = request.getParameter("option5");
        String correctAnswer = request.getParameter("correctAnswer");
        String questionType = request.getParameter("questionType");
        int quizId = Integer.parseInt(request.getParameter("quizId"));

        // Question obyektini yarat
        Question question = new Question();
        question.setQuestionText(questionText);
        question.setOption1(option1);
        question.setOption2(option2);
        question.setOption3(option3);
        question.setOption4(option4);
        question.setOption5(option5);
        question.setCorrectAnswer(correctAnswer);
        question.setQuestionType(questionType);
        question.setQuizId(quizId);

        boolean added = questionDAO.addQuestion(question);

        if (added) {
            // əlavə olundu
            response.sendRedirect("success.jsp"); // yaxud istədiyin səhifə
        } else {
            // səhv oldu
            request.setAttribute("errorMessage", "Sual əlavə edilərkən xəta baş verdi!");
            request.getRequestDispatcher("addQuestion.jsp").forward(request, response);
        }
    }
}

