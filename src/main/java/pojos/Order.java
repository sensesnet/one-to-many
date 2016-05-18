package pojos;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

/**
 * Created by KIRILL on 18.05.2016.
 */
@Entity
@Table(name="USER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "meal_Id", unique = false, nullable = false)
    private int mealId;

    @Column(name = "user_Id", unique = false, nullable = false)
    private int userId;

    @ManyToOne( fetch = FetchType.LAZY)
    //@Cascade(CascadeType.ALL)
    @JoinColumn(name = "order_Id")
    private OrderStatus orderStatus;

    public OrderStatus getOrderStatus() {return orderStatus;}

    public void setOrderStatus(OrderStatus orderStatus) {this.orderStatus = orderStatus;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
