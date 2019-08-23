/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ahmed
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {
    }

    public static CustomerFacade getBookFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer addCustomer(String firstN, String lastN) {
        Customer customer = new Customer(firstN, lastN);

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }
    
    /*
    public Customer findBook(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }
*/
    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer", Customer.class);
            return query.getResultList();
            
        } finally {
            em.close();
        }
    }
    int getNumberOfCustomers(){
    
        EntityManager em = emf.createEntityManager();
        try{
            Query q1 = em.createQuery("SELECT COUNT(p) FROM Customer p");
            System.out.println("Total amount customers: " + q1.getSingleResult());
            int val = (Integer) q1.getSingleResult();
            return val;
        }finally{
        em.close();
        }
     //  Query q1 = em.createQuery("SELECT COUNT(p) FROM Doint p");
        // System.out.println("Total Points: " + q1.getSingleResult());
    }

    Customer findByID(int id){
    EntityManager em = emf.createEntityManager();
    try{
    Customer customer = em.find(Customer.class, id);
    return customer; 
    }finally{
    em.close();
    }
       
    }

    List<Customer> findByLastName(String lastName){
    
        EntityManager em = emf.createEntityManager();
        try{
            //Query q1 = em.createQuery("\"SELECT p FROM Customer p WHERE Customer.p =LASTNAME");
            TypedQuery<Customer> qList =  em.createQuery("SELECT p FROM Customer p WHERE Customer.p = '" + lastName + "'", Customer.class); 
            return qList.getResultList();
            
        }finally{
        em.close();
        }
     //  Query q1 = em.createQuery("SELECT COUNT(p) FROM Doint p");
        // System.out.println("Total Points: " + q1.getSingleResult());
    }

//    
//Ex-2 Continued - Adding a facade
//
//Add a facade to the project, using the template given in the section JPA With a Facade in the intro tutorial.
//Provide the facade with the following methods:
//
//Customer findByID(int id);
//List<Customer> findByLastName(String name);
//int getNumberOfCustomers();
//List<Customer> allCustomers();
//Customer addCustomer(String fName, String lName);
//
//
//Test the facade, first, with a simple main method, similar to what was done in the intro tutorial. Next step, however, will require you to write a JUnit test for the facade.
//

//Ex-3  Add a JUnit Test to your facade
//We will have much more focus on test in week-3, so take this as an appetizer to how we are going to develop throughout the semester. Today, this is marked as yellow/red, but later you are all expected to provide automated tests for your code.
//
//For this exercise just use the database used up until now. When we start to do testing “for real” we will add an additional database, meant only for testing.
//
//Create a new JUnit test for your facade class, using the wizard “Test for Existing Class”
//
//Use your knowledge from the previous semester and try to design a test that will ensure that the database is in a well known state before EACH test.
//
//Test the facade methods in this test.

   // List<Customer> allCustomers();


}
