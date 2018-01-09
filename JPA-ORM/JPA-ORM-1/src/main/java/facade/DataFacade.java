package facade;

import Entities.Customer;
import Entities.CustomerOrder;
import Entities.ItemType;
import Entities.OrderLine;
import java.util.ArrayList;
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

    public Customer createCustomer(Customer customer) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

    public Customer findCustomer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Customer foundCustomer = em.find(Customer.class, id);
            em.getTransaction().commit();
            return foundCustomer;
        } finally {
            em.close();
        }
    }

    public ItemType createItemType(ItemType item) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
            return item;
        } finally {
            em.close();
        }
    }

    public CustomerOrder createOrder(CustomerOrder order) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
            return order;
        } finally {
            em.close();
        }
    }

    public void addOrder(Integer orderId, Integer id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, id);
            CustomerOrder order = em.find(CustomerOrder.class, orderId);
            customer.addOrder(order);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public CustomerOrder findOrder(Integer orderId) {
        EntityManager em = getEntityManager();
        try {
            CustomerOrder order = em.find(CustomerOrder.class, orderId);
            return order;
        } finally {
            em.close();
        }
    }
}
