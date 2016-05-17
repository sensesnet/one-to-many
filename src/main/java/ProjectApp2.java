import org.hibernate.Session;
import pojos.Order;
import pojos.OrderStatus;
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
        order.setOrderStatus(orderStatus);
        orderStatus.getOrders().add(order);

        session.save(order);        // save

        session.getTransaction().commit();
        System.out.println("Done");


    }
}
