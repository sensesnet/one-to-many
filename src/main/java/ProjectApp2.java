import org.hibernate.Session;
import pojos.OrderStatus;
import pojos.Order;
import util.HibernateUtil;

/**
 * Created by KIRILL on 16.05.2016.
 */
public class ProjectApp2 {

    public static void main(String[] args) {


        System.out.println("Hibernate one to many (Annotation)");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setTotalPrice(100);
        orderStatus.setTotalTime(100);
        orderStatus.setOrderStatus("to admin");
        session.save(orderStatus);
        System.out.println("Add new OrderStatus");

        Order order = new Order();
        order.setMealId(12);
        order.setUserId(13);


        Order order1 = new Order();
        order1.setMealId(10);
        order1.setUserId(10);

                                        //add orderstatus to order
        order.setOrderStatus(orderStatus);
        order1.setOrderStatus(orderStatus);

        session.save(order);
        session.save(order1);                                             // save


        orderStatus.getOrders().add(order);
        orderStatus.getOrders().add(order1);
        session.update(orderStatus);


        session.getTransaction().commit();
        System.out.println("Done");


    }
}
