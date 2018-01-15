/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c1.examprep_rest_api;

import com.c1.examprep_rest_api.Facade.PetFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mathiasjepsen
 */
@Path("pet")
public class PetResource {
    
    PetFacade pf = new PetFacade();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PetResource
     */
    public PetResource() {
        pf.addEntityManagerFactory(Persistence.createEntityManagerFactory("master"));        
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPets() {
        List<JSONPet> jsonpets = new ArrayList();
        List<Pet> pets = pf.getAllPets();
        for (Pet p : pets) {
            JSONPet pet = new JSONPet(p);
            jsonpets.add(pet);
        }
        return gson.toJson(jsonpets);
    }
    
    @Path("count")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getTotalNumberOfPets() {
        return "{\"petCount:\"" + pf.getAllPets().size() + "}";
    }
    
    @Path("living")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllLivingPets() {
        List<JSONPet> jsonpets = new ArrayList();
        List<Pet> pets = pf.getAllLivingPets();
        for (Pet p : pets) {
            JSONPet pet = new JSONPet(p);
            jsonpets.add(pet);
        }
        return gson.toJson(jsonpets);
    }
    
    @Path("{date}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getPetsWithEvent(@PathParam("date") java.sql.Date date) {
        List<JSONPet> jsonpets = new ArrayList();
        List<Pet> pets = pf.getPetsWithEvent(date);
        for (Pet p : pets) {
            JSONPet pet = new JSONPet(p);
            jsonpets.add(pet);
        }
        return gson.toJson(jsonpets);
    }
    
    @Path("{petId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createEventForPet(@PathParam("petId") int id, String event) {
        JSONEvent e = new JSONEvent(gson.fromJson(event, Event.class));
        return gson.toJson(pf.addNewPetEvent(id, e));
    }
    
    /**
     * PUT method for updating or creating an instance of PetResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        
    }
}
