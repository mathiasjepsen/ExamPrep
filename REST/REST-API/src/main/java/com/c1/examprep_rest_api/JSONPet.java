/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c1.examprep_rest_api;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author mathiasjepsen
 */
public class JSONPet {
    
    private int id;
    private String name;
    private Date birth;
    private String species;
    private String ownerFName;
    private String ownerLName;
    
    public JSONPet(Pet p) {
        this.id = p.getId();
        this.name = p.getName();
        this.birth = p.getBirth();
        this.species = p.getSpecies();
        this.ownerFName = p.getOwnerId().getFirstName();
        this.ownerLName = p.getOwnerId().getLastName();
    }


    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getOwnerFName() {
        return ownerFName;
    }

    public void setOwnerFName(String ownerFName) {
        this.ownerFName = ownerFName;
    }

    public String getOwnerLName() {
        return ownerLName;
    }

    public void setOwnerLName(String ownerLName) {
        this.ownerLName = ownerLName;
    }
    
    
    
}
