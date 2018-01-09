package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author mathiasjepsen
 */
@Entity
public class ItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String name;
    private String description;
    private double price;
    @OneToMany(mappedBy = "itemType", cascade = CascadeType.PERSIST)
    private List<OrderLine> orderlines;

    public ItemType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }
    
    public void addOrderline(OrderLine orderline) {
        if (orderlines == null) {
            orderlines = new ArrayList();
        }
        orderlines.add(orderline);
    }
    
}
