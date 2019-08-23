/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ahmed
 */
@Path("Vald")
public class ValdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ValdResource
     */
    public ValdResource() {
    }

    /**
     * Retrieves representation of an instance of rest.ValdResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("/vald")
    @Produces(MediaType.APPLICATION_JSON)
    public String returnVald(){
    
    return "this is a text with \'vald\' written";
    }

    /**
     * PUT method for updating or creating an instance of ValdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
