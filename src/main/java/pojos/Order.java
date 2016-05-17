package pojos;

import javax.persistence.*;


@Entity                   //  annotation describe DB table how javaclass
@Table(name = "Order")       //  table name
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // value autogenerate
    @Column( name = "Id")
    private int id;       //autoincrement identify explicitly column

    @Column(name = "mealId")
    private int mealId;

    @Column(name = "userId")
    private int userId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private OrderStatus orderStatus;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getMealId() {return mealId;}
    public void setMealId(int mealId) {this.mealId = mealId;}

    public int getUserId() {return userId;}
    public void setUserId(int userId) {this.userId = userId;}

    public OrderStatus getOrderStatus() {return this.orderStatus;}
    public void setOrderStatus(OrderStatus orderStatus) {this.orderStatus = orderStatus;}
}
