package com.example.demologin.dao;

import com.example.demologin.model.Question;
import com.example.demologin.util.DbClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class QuestionDAO {

    public boolean addQuestion(Question question) {
        String sql = "INSERT INTO questions " +
                "(question_text, option1, option2, option3, option4, option5, correct_answer, question_type, quiz_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbClass.CONNECTION;
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, question.getQuestionText());
            ps.setString(2, question.getOption1());
            ps.setString(3, question.getOption2());
            ps.setString(4, question.getOption3());
            ps.setString(5, question.getOption4());
            ps.setString(6, question.getOption5());
            ps.setString(7, question.getCorrectAnswer());
            ps.setString(8, question.getQuestionType());
            ps.setInt(9, question.getQuizId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Question> getQuestionsByQuizId(int quizId) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions WHERE quiz_id = ?";

        try (Connection conn = DbClass.CONNECTION;
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, quizId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuestionText(rs.getString("question_text"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setOption4(rs.getString("option4"));
                q.setOption5(rs.getString("option5"));
                q.setCorrectAnswer(rs.getString("correct_answer"));
                q.setQuestionType(rs.getString("question_type"));
                q.setQuizId(rs.getInt("quiz_id"));

                questions.add(q);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }
}

