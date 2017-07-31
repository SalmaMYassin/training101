/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trial.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salma
 */
public class TaskService {

    private Connection conn;

    TaskService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/taskdb", "root", "root");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public List<Task> getAllTasks() {       //working
        ArrayList tasks = new ArrayList<Task>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tasks");
            while (rs.next()) {
                Task newTask = new Task(rs.getString("task"), rs.getBoolean("done"), rs.getString("due"), rs.getString("details"), rs.getInt("id"));
                tasks.add(newTask);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;

    }
    

    public Task addTask(Task newTask) {     //working
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO tasks (task, done) VALUES ('" + newTask.getTask() + "', false)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newTask;
    }
    

    public void deleteTask(int id) {        //working
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM tasks WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void setDone(int id) {       //working
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE tasks SET done = true WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void deleteDone() {      //working
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM tasks WHERE done = true");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void saveTask(int id, Task update) {     //working
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE tasks SET task = '" + update.getTask() + "', due = '" + update.getDue()
                    + "',details = '" + update.getDetails() + "'"
                    + "WHERE id = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
