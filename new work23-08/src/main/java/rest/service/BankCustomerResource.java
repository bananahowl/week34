package rest.service;

import com.google.gson.Gson;
import dto.CustomerDTO;
import entities.BankCustomer;
import facades.BankFacade;
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

@Path("bankcustomer")
public class BankCustomerResource {
    // befor you can use the singleton, you gotta create a Entitymangerfactory first.
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    BankFacade facade = BankFacade.getBankFacade(emf);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public String getCustomerID(BankCustomer entity, @PathParam("id") int id) {
        //throw new UnsupportedOperationException();
        BankCustomer customer = facade.getCustomerByID(id);
        CustomerDTO customerDTO = new CustomerDTO(customer);
        Gson gson = new Gson();

        return gson.toJson(customerDTO);
    }

    @GET
    @Path("/all")
    @Consumes({MediaType.APPLICATION_JSON})
    public String getGTOList(String name) {
        List<BankCustomer> customerList = facade.getAllCustomers();//facade.getCustomerByName(name);

//        List<CustomerDTO> DTOList = new ArrayList<>();
//        for (BankCustomer customer : customerList) {
//            DTOList.add(new CustomerDTO(customer));
//        }
//        basicList.add(facade.getCustomerByName(entity));
        Gson gson = new Gson(); 
        
        return gson.toJson(customerList);

    }

}
