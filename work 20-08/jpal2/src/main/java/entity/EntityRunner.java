
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import facade.CustomerFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ahmed
 */
public class EntityRunner {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bu2");
        EntityManager em = emf.createEntityManager();
        Customer customer1 = new Customer("Bob", "Larsen");
        Customer customer2 = new Customer("Mågens", "åge");
        Customer customer3 = new Customer("Sam", "Flixen");
        try {
            em.getTransaction().begin();
            em.persist(customer1);
//            em.persist(customer2);
//            em.persist(customer3);
            em.getTransaction().commit();
            //Verify that books are managed and has been given a database id
//            System.out.println(customer1.getId());
//            System.out.println(customer2.getId());
//            System.out.println(customer3.getId());
//            System.out.println("values are: " + customer1.getFirstName() + ", date : " + customer1.getCreated() + "\n");
//
//            System.out.println("values are: " + customer2.getFirstName() + ", date : " + customer2.getCreated() + "\n");
//            System.out.println("values are: " + customer3.getFirstName() + ", date : " + customer3.getCreated() + "\n");
            CustomerFacade fadd = CustomerFacade.getBookFacade(emf);
            fadd.addCustomer("bob", "dolfen");
            System.out.println(fadd.getAllCustomers());
        } finally {
            em.close();
        }
    }

}


