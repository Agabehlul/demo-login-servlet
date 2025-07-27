package com.example.demologin.dao;

import com.example.demologin.model.Student;
import com.example.demologin.util.DbClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Connection conn = DbClass.CONNECTION;
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setSurname(rs.getString("surname"));
                s.setFatherName(rs.getString("fathername"));
                s.setGrade(rs.getString("grade"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));

                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
