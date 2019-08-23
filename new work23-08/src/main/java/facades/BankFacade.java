package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankFacade {

    private static BankFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private BankFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankFacade getBankFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public BankCustomer getCustomerByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            //Query q1 = em.createQuery("\"SELECT p FROM Customer p WHERE Customer.p =LASTNAME");
            TypedQuery<BankCustomer> qList = em.createQuery("SELECT c FROM BankCustomer c WHERE c.id = :id", BankCustomer.class);
            qList.setParameter("id", id);
            return qList.getSingleResult();

        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getCustomerByName(String name) {

        EntityManager em = emf.createEntityManager();
        try {
            //Query q1 = em.createQuery("\"SELECT p FROM Customer p WHERE Customer.p =LASTNAME");
            TypedQuery<BankCustomer> qList = em.createQuery("SELECT c FROM BankCustomer c WHERE c.firstName = :name", BankCustomer.class);
            qList.setParameter("name", name);
            
           // List<CustomerDTO> DTOList = new ArrayList<>();
//            for (BankCustomer customer : qList.getResultList()) {
//                DTOList.add(new CustomerDTO(customer));
//
//            }
            return qList.getResultList();

        } finally {
            em.close();
        }
    }
    public List<BankCustomer> getAllCustomers() {

        EntityManager em = emf.createEntityManager();
        try {
            //Query q1 = em.createQuery("\"SELECT p FROM Customer p WHERE Customer.p =LASTNAME");
            TypedQuery<BankCustomer> qList = em.createQuery("SELECT c FROM BankCustomer c", BankCustomer.class);
            

            return qList.getResultList();

        } finally {
            em.close();
        }
    }
}
