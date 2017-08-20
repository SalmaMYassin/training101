/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.anotherone;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Salma
 */
public class TaskManager {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taskPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void addTask(Task newTask) {
        entityManager.getTransaction().begin();
        entityManager.persist(newTask);
        entityManager.getTransaction().commit();
    }

    public List<Task> allTasks() {
        List<Task> tasks = new ArrayList<Task>();
        entityManager.getTransaction().begin();
        tasks = entityManager.createQuery("SELECT um FROM Task um").getResultList();
        entityManager.getTransaction().commit();
        return tasks;
    }

    public void deleteTask(int taskID) {
        Task task = entityManager.find(Task.class, taskID);
        entityManager.getTransaction().begin();
        entityManager.remove(task);
        entityManager.getTransaction().commit();
    }
    
    public void setDone(int taskID){
        Task task = entityManager.find(Task.class, taskID);
        entityManager.getTransaction().begin();
        task.setDone(true);
        entityManager.getTransaction().commit();
    }
    
    public void deleteDone(){
        List<Task> tasks = entityManager.createQuery("SELECT um FROM Task um").getResultList();
        
        entityManager.getTransaction().begin();
        for(Task t:tasks){
            if(t.isDone())
                entityManager.remove(t);
        }
        entityManager.getTransaction().commit();
    }
    
    public void saveTask(int taskID,Task update){
        Task task = entityManager.find(Task.class, taskID);
        entityManager.getTransaction().begin();
        task.setDetails(update.getDetails());
        task.setTask(update.getTask());
        task.setDue(update.getDue());
        entityManager.getTransaction().commit();
    }
}
