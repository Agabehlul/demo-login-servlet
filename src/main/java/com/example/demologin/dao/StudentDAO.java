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
    public static Student getStudentById(int studentId) {
        Student student = null;

        try (Connection conn = DbClass.CONNECTION){
            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setFatherName(rs.getString("father_name"));
                student.setGrade(rs.getString("grade"));
                student.setUsername(rs.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

}
