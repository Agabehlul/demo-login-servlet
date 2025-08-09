package com.example.demologin.dao;

import com.example.demologin.model.Teacher;
import com.example.demologin.util.DbClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        try (Connection conn = DbClass.CONNECTION;
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM teachers")) {

            while (rs.next()) {
                Teacher t = new Teacher();
                t.setId(rs.getInt("id"));
                t.setFullName(rs.getString("full_name"));
                t.setUsername(rs.getString("username"));
                t.setPassword(rs.getString("password"));

                teachers.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teachers;
    }
}
