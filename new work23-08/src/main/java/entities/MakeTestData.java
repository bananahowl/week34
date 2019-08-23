/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author ahmed
 */
public class MakeTestData {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
         BankCustomer dm1 = new BankCustomer("fred", "bobsen", "bk1", 0, 0, "info");
         BankCustomer dm2 = new BankCustomer("lise", "bobsen", "bk2", 0, 0, "info");
         BankCustomer dm3 = new BankCustomer("loft", "bobsen", "bk3", 0, 0, "info");
         
        ;
        try {
            em.getTransaction().begin();
            em.persist(dm1);
            em.persist(dm2);
            em.persist(dm3);
            em.getTransaction().commit();
            //Verify that books are managed and has been given a database id
            System.out.println(dm1.getId());
            System.out.println(dm2.getId());
            System.out.println(dm3.getId());
            System.out.println(dm3.toString());
        } finally {
            em.close();
        }
    }

   
    
}


