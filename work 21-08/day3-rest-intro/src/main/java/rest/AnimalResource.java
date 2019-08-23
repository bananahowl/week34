/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
@Path("animal")
public class AnimalResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Hello from my first web service";
    }
//     -- __ --- ** ** TIL EXCERISE 1.
//    13- Change the url to localhost:8080/rest1/api/animal
//    to make it work i need to write : http://localhost:8080/api/animal

    public ArrayList<Animal> makeListAni() {

        ArrayList<Animal> animalList = new ArrayList<>();

        Animal anim1 = new Animal("dog", 2, "bark");
        Animal anim2 = new Animal("cat", 3, "miav");
        Animal anim3 = new Animal("duck", 1, "quack");
        Animal anim4 = new Animal("donket", 4, "HEYYHAYY");
        animalList.add(anim1);
        animalList.add(anim2);
        animalList.add(anim3);
        animalList.add(anim4);
        return animalList;
    }
    
    public int randNumber(int size){
    
        Random rando = new Random();
        int val = rando.nextInt(size);
        return val;
    }
    
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String returnBoos() {
        ArrayList<Animal> animalList = makeListAni();
        Animal valu = animalList.get(randNumber(animalList.size()));
        
        Gson gson = new Gson(); // gotta get this part ddddude
        return gson.toJson(valu);
        
     //   return "ehh vald no time no see hows the bois!!?";
        /*Random rand = new Random();
    int val = rand.nextInt() +1;
    return val;*/
    }
    public String animalGson(){
        String randAnimal = returnBoos();
        GsonBuilder gsonB = new GsonBuilder();
        Gson gson = new Gson(); // gotta get this part ddddude
        return gson.toJson(randAnimal);
        
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
