/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jdbc.playground;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ee
 *
 * @author Salma
 */
public class App {

    public static void main(String[] args) {

        try {
            // 1. Activate the Driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/taskdb", "root", "root");

            Statement stmt = conn.createStatement();

            stmt.executeUpdate("INSERT INTO tasks (task, due, done, details) VALUES ('clean', '5/6/2017' , 0, 'clean well')");

            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks");

            while (rs.next()) {
                String name = rs.getString("task");
                boolean s = rs.getBoolean("done");
                String a = rs.getString("due");
                String b = rs.getString("details");
                int c = rs.getInt("id");

                System.out.println(name + " " + s + " " + a + " " + b + " " + c);
            }

            //stmt.executeUpdate("INSERT INTO students (name, age) VALUES ('salma', 16)");
            //ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            //stmt.executeUpdate("UPDATE students SET age = 17 WHERE name = 'salma'"); 
            //stmt.executeUpdate("DELETE FROM students WHERE id = 4");
            // CRUD | DML
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
