package Test;

import Entities.Customer;
import Entities.CustomerOrder;
import Entities.ItemType;
import Entities.OrderLine;
import facade.DataFacade;
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
        
//        Customer customer = new Customer();
//        customer.setName("Lovro");
//        customer.setEmail("lovro@mail.com");
//        df.createCustomer(customer);
//        
//        ItemType potato = new ItemType();
//        potato.setName("potato");
//        potato.setPrice(12.3);
//        potato.setDescription("This is a potato");
//        df.createItemType(potato);
//        
//        ItemType tomato = new ItemType();
//        tomato.setName("tomato");
//        tomato.setPrice(5.7);
//        tomato.setDescription("This is a tomato");
//        df.createItemType(tomato);
//        
//        OrderLine potatoes = new OrderLine();
//        potatoes.setQuantity(1000);
//        potatoes.setItemType(potato);
//        
//        OrderLine tomatoes = new OrderLine();
//        tomatoes.setQuantity(3000);
//        tomatoes.setItemType(tomato);
//        
//        CustomerOrder order = new CustomerOrder();
//        order.addOrderline(potatoes);
//        order.addOrderline(tomatoes);
//        df.createOrder(order);
        
//        df.addOrder(2, 1);
            CustomerOrder order = df.findOrder(2);
            double total = 0;
            for (OrderLine orderline : order.getOrderlines()) {
                total += orderline.getQuantity() * orderline.getItemType().getPrice();
            }
            System.out.println("Total: " + total);
    }
}
