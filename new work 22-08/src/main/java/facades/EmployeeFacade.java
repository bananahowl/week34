package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private EmployeeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Employee getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> qList = em.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class);
            qList.setParameter("id", id);
            return qList.getSingleResult();

        } finally {
            em.close();
        }
    }

    public Employee getEmployeesByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> qList = em.createQuery("SELECT e FROM Employee e WHERE e.name = :name", Employee.class);
            qList.setParameter("name", name);
            return qList.getSingleResult();

        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {

        EntityManager em = emf.createEntityManager();
        try {
            //Query q1 = em.createQuery("\"SELECT p FROM Customer p WHERE Customer.p =LASTNAME");
            TypedQuery<Employee> qList = em.createQuery("SELECT e FROM Employee e", Employee.class);

            return qList.getResultList();

        } finally {
            em.close();
        }
    }

    public List<Employee> getEmployeesWithHighestSalary() {

        EntityManager em = emf.createEntityManager();
        try {
            //Query q1 = em.createQuery("\"SELECT p FROM Customer p WHERE Customer.p =LASTNAME");
            TypedQuery<Employee> qList = em.createQuery("SELECT e FROM Employee e", Employee.class);

            return qList.getResultList();

        } finally {
            em.close();
        }
    }

//    createEmployee
}
