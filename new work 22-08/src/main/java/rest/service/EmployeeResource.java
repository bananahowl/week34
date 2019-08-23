package rest.service;

import DTO.EmployeeDTO;
import com.google.gson.Gson;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("employee")
public class EmployeeResource {

    EntityManagerFactory emf =Persistence.createEntityManagerFactory("pu");
    EmployeeFacade facade =  EmployeeFacade.getFacadeExample(emf);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Employee entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllEmployees() {
        List<Employee> employeeList = facade.getAllEmployees();//facade.getCustomerByName(name);

        List<EmployeeDTO> DTOList = new ArrayList<>();
        for (Employee customer : employeeList) {
            DTOList.add(new EmployeeDTO(customer));
        }
        
        Gson gson = new Gson(); 
        
        return gson.toJson(DTOList);
    }
}
