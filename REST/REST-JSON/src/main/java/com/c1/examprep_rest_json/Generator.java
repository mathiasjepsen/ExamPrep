/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c1.examprep_rest_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author mathiasjepsen
 */
public class Generator {
    
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    List<String> firstNames = new ArrayList() {
        {
            add("Mathias");
            add("Lovro");
            add("Thomas");
            add("Peter");
            add("Petru");
            add("Patrick");
        }
    };
    
    List<String> lastNames = new ArrayList() {
        {
            add("Jepsen");
            add("Biljeskovic");
            add("Thimothee");
            add("Catana");
            add("Fenger");
            add("Mihok");
        }
    };
    
//    public String generate(int n1, int n2) {
//        StringBuilder sb = new StringBuilder();
//        Random random = new Random();
//        sb.append("[");
//        for (int i = 0; i < n1; i++) {
//            sb.append("{\"fname\":")
//                    .append(firstNames.get(random.nextInt(firstNames.size())))
//                    .append(", \"lname\":")
//                    .append(lastNames.get(random.nextInt(lastNames.size())))
//                    .append(", \"id\":")
//                    .append(n2)
//                    .append(", \"age\":")
//                    .append(random.nextInt(70) + 18)
//                    .append("},\n");
//            n2++;
//        }
//        return sb.toString();
//    }
    
    public String generateJSON(int n1, int n2) {
        Random random = new Random();
        List<Person> persons = new ArrayList();
        for (int i = 0; i < n1; i++) {
            persons.add(new Person(n2, 
                    firstNames.get(random.nextInt(firstNames.size())), 
                    lastNames.get(random.nextInt(lastNames.size())), 
                    random.nextInt((70 - 17) + 1) + 17));
            n2++;
        }
        return gson.toJson(persons);
    }
    
}
