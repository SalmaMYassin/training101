/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernateexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Salma
 */
public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mypu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        Customer c = new Customer();
        entityManager.persist(c);

        entityManager.getTransaction().commit();

    }
}
