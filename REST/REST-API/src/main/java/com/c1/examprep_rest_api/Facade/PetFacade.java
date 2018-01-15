package com.c1.examprep_rest_api.Facade;

import com.c1.examprep_rest_api.Event;
import com.c1.examprep_rest_api.JSONEvent;
import com.c1.examprep_rest_api.Pet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author mathiasjepsen
 */
public class PetFacade {

    private EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Pet> getAllPets() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Pet p");
            List<Pet> pets = q.getResultList();
            return pets;
        } finally {
            em.close();
        }
    }

    public List<Pet> getAllLivingPets() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Pet p WHERE p.death = null");
            List<Pet> pets = q.getResultList();
            return pets;
        } finally {
            em.close();
        }
    }

    public List<Pet> getAllPetsWithOwners() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Pet p");
            List<Pet> pets = q.getResultList();
            return pets;
        } finally {
            em.close();
        }
    }

    public List<Pet> getPetsWithEvent(java.sql.Date date) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Pet p JOIN p.eventCollection e WHERE e.date = :date");
            q.setParameter("date", date);
            List<Pet> pets = q.getResultList();
            return pets;
        } finally {
            em.close();
        }

    }
    
    public JSONEvent addNewPetEvent(int petId, JSONEvent event) {
        EntityManager em = getEntityManager();
        try {
            Pet pet = em.find(Pet.class, petId);
            Event e = new Event();
            e.setPetId(pet);
            e.setEvent(event.getEvent());
            e.setRemark(event.getRemark());
            e.setDate(event.getDate());
            em.getTransaction().begin();
            pet.getEventCollection().add(e);
            em.getTransaction().commit();
            return event;
        } finally {
            em.close();
        }
    }
       
}
