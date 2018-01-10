/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Student;
import entity.Teacher;
import facade.DataFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mathiasjepsen
 */
public class Main {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_exam");
        DataFacade df = new DataFacade(emf);
        List<Student> students = df.getStudentsByLastname("And");
        Long count = df.getTotalSumOfStudents("CLdat-a14e");
        Teacher teacher = df.getTeacherWithMostSemesters();
        
//        for (Student student : students) {
//            System.out.println(student.getFirstname());
//        }
        
        System.out.println(teacher.getFirstname());
        
    }
    
}
