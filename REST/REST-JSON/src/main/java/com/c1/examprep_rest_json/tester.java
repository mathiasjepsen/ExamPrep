/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c1.examprep_rest_json;

/**
 *
 * @author mathiasjepsen
 */
public class tester {
    
    public static void main(String[] args) {
        Generator g = new Generator();
        System.out.println(g.generateJSON(100, 10));
    }
    
}
