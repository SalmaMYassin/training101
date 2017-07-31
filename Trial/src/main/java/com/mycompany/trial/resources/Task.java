/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trial.resources;

import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Salma
 */

@XmlRootElement
public class Task {
    private String task;
    private boolean done;
    private String due;
    private String details;
    private int id;

    public Task() {
    
    }

    public Task(String task, int id) {
        this.task = task;
        this.done = false;
        this.due = null;
        this.details = null;
        this.id = id;
    }

    public Task(String task, String due, String details, int id) {
        this.task = task;
        this.due = due;
        this.details = details;
        this.id = id;
    }

    public Task(String task, boolean done, String due, String details, int id) {
        this.task = task;
        this.done = done;
        this.due = due;
        this.details = details;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }

    public String getDue() {
        return due;
    }

    public String getDetails() {
        return details;
    }
    
    
}
