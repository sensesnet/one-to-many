package pojos;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity                   //  annotation describe DB table how javaclass
@Table(name = "OrderStatus")       //  table name
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
    private int orderId;

    @Column(name = "totalPrice",unique = false,nullable = false)
    private int totalPrice;

    @Column(name = "totalTime",unique = false,nullable = false)
    private int totalTime;

    @Column(name = "orderStatus",unique = false,nullable = false,length = 20)
    private String orderStatus;

    @OneToMany(cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY, mappedBy = "orderStatus")
    private Set<Order> orders = new HashSet<Order>(0);


    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


    public int getTotalTime() {
        return totalTime;
    }
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getOrderStatus() {return orderStatus;}
    public void setOrderStatus(String orderStatus) {this.orderStatus = orderStatus;}

    public Set<Order> getOrders() {return this.orders;}
    public void setOrders(Set<Order> orders) {this.orders = orders;}
}
