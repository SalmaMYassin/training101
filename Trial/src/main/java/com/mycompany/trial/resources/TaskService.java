/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trial.resources;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Salma
 */
public class TaskService {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("taskpu");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

//    public List<Task> getAllTasks() {
//        entityManager.getTransaction().begin();
//
//        List tasks = entityManager.createQuery("SELECT * FROM task").getResultList();
//
//        entityManager.getTransaction().commit();
//        return tasks;
//    }
    public Task addTask(Task task) {
        entityManager.getTransaction().begin();

        entityManager.persist(task);

        entityManager.getTransaction().commit();
        return task;
    }

}
