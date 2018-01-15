package com.c1.examprep_rest_api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author mathiasjepsen
 */
public class JSONConverter {
    
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Pet getPetFromJson(String js){
        return gson.fromJson(js, Pet.class);
    }  
    public static String getJSONFromPet(Pet p) {
        return gson.toJson(p);
    }  
    public static String getJSONFromPet(List<Pet> pets) {
        
        return gson.toJson(pets);
    }  


}
