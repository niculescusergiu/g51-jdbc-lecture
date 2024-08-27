package se.lexicon;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCExamples {
    public static void main(String[] args) {
        ex2();
    }

    //Get all student's data from the database (findAll)
    public static void ex1() {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "root");
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from student");
            ResultSet resultSet = statement.executeQuery("select * from student");
            List<Student> studentList = new ArrayList<>();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                LocalDate createDate = resultSet.getDate("create_date").toLocalDate();

                Student student = new Student(studentId, firstName, lastName, email, age, createDate);
                studentList.add(student);

            }
            studentList.forEach(System.out::println);

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public static void ex2() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student where student_id = 1");
            preparedStatement.executeQuery("select * from student where student_id = 1");
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            ex.printStackTrace();
        }

    }
}
