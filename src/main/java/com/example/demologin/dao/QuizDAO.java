package com.example.demologin.dao;

import com.example.demologin.model.Quiz;
import com.example.demologin.util.DbClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuizDAO {

    private final Connection connection;

    public QuizDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createQuiz(Quiz quiz) {
        String sql = "INSERT INTO quizzes (title, grade) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, quiz.getTitle());
            stmt.setInt(2, quiz.getGrade());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
