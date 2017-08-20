/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anotherone;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Salma
 */
@Path("/tasks")
public class TaskServices {

    TaskManager get = new TaskManager();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> ViewAll() {
        return get.allTasks();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTask(Task newTask) {
        get.addTask(newTask);
    }

    @GET
    @Path("/delete/{taskID}")
    @Produces(MediaType.TEXT_PLAIN)
    public void deleteTask(@PathParam("taskID") int taskID) {
        get.deleteTask(taskID);
    }

    @GET
    @Path("/done/{taskID}")
    @Produces(MediaType.TEXT_PLAIN)
    public void setDone(@PathParam("taskID") int taskID) {
        get.setDone(taskID);
    }
    
    @GET
    @Path("/deletedone")
    @Produces(MediaType.TEXT_PLAIN)
    public void delDone() {
        get.deleteDone();
    }
    
    @POST
    @Path("/update/{taskID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void update(@PathParam("taskID") int taskID, Task update) {
        get.saveTask(taskID, update);
    }
}
