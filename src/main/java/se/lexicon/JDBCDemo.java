package se.lexicon;

import se.lexicon.db.MySQLConnection;

import java.sql.*;
import java.time.LocalDate;

public class JDBCDemo {
    public static void main(String[] args) {
        try{
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
        statement.executeQuery("select * from student");
        ResultSet resultSet = statement.executeQuery("select * from student");

        while (resultSet.next()){
        int studentId = resultSet.getInt("student_id");
            System.out.println("Student ID: " + studentId);
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            System.out.println(studentId + ", " + firstName + ", " + lastName);
        }



        //executeQuery method is used for executing SELECT or READ queries
            //executeUpdate method is used for executing INSERT, UPDATE, DELETE queries


        } catch(SQLException ex){
            System.out.println("SQL Exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
