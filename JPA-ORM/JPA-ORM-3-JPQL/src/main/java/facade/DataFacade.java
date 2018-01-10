/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Student;
import entity.Teacher;
import static entity.Teacher_.firstname;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mathiasjepsen
 */
public class DataFacade {

    EntityManagerFactory emf;

    public DataFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Student> getAllStudents() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Student.findAll", Student.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Student> getStudentsByFirstname(String firstname) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Student.findByFirstname").setParameter("firstname", firstname).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Student> getStudentsByLastname(String lastname) {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery("Student.findByLastname").setParameter("lastname", lastname).getResultList();
        } finally {
            em.close();
        }
    }

    public Long getTotalSumOfStudents(String semesterName) {
        EntityManager em = getEntityManager();
        try {
            return (Long) em.createQuery("SELECT COUNT(s.id) FROM Student s JOIN s.currentsemesterId sem WHERE sem.name = :semesterName").setParameter("semesterName", semesterName).getSingleResult();
        } finally {
            em.close();
        }
    }

    public Long getTotalSumOfStudentsInAllSemesters() {
        EntityManager em = getEntityManager();
        try {
            return (Long) em.createQuery("SELECT COUNT(s.id) FROM Student s WHERE s.currentsemesterId != NULL").getSingleResult();
        } finally {
            em.close();
        }
    }

    public Teacher getTeacherWithMostSemesters() {
        EntityManager em = getEntityManager();
        try {
            return (Teacher) em.createQuery("SELECT t FROM Teacher t WHERE SIZE(t.semesterList) = (SELECT MAX(SIZE(t2.semesterList)) FROM Teacher t2)").getSingleResult();
        } finally {
            em.close();
        }
    }

}
