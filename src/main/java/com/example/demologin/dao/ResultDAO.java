package com.example.demologin.dao;

import com.example.demologin.model.Result;
import com.example.demologin.util.DbClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {

    public static List<Result> getResultsByStudentId(int studentId) {
        List<Result> resultList = new ArrayList<>();

        try (Connection conn = DbClass.CONNECTION) {
            String query = "SELECT * FROM results WHERE student_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Result result = new Result();
                result.setId(rs.getInt("id"));
                result.setStudentId(studentId);
                result.setQuizId(rs.getInt("quiz_id"));
                result.setScore(rs.getInt("score"));
                resultList.add(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }
}
