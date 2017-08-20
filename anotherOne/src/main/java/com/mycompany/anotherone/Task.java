/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anotherone;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salma
 */
@XmlRootElement
@Entity
public class Task implements Serializable {
    
    @Id @GeneratedValue
    private int id;
    private String task;

    @NotNull
    private boolean done;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date due;
    private String details;
    

    public Task() {
        this.done = false;
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

    public void setDue(Date due) {
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

    public Date getDue() {
        return due;
    }

    public String getDetails() {
        return details;
    }
    
    
}
