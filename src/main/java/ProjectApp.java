import Dao.Factory;
import Dao.OrderDao;
import Dao.OrderStatusDao;
import pojos.Order;
import pojos.OrderStatus;

import java.sql.SQLException;

/**
 * Created by KIRILL on 16.05.2016.
 */
public class ProjectApp {
    public static void main(String[] args) throws SQLException {

        Factory factory = Factory.getInstanse();
        OrderStatusDao orderStatusDao = factory.getOrderStatusDao();


        System.out.println("Use mapping one OrderStatus to many Orders ");


        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setTotalPrice(100);
        orderStatus.setTotalTime(100);
        orderStatus.setOrderStatus("to admin");
        orderStatusDao.add(orderStatus);
        System.out.println("Add new OrderStatus");


        OrderDao orderDao = factory.getOrderDao();
        Order order = new Order();
        order.setMealId(1);
        order.setUserId(1);
        order.setOrderStatus(orderStatus);
        orderStatus.getOrders().add(order);
        orderDao.add(order);
        System.out.println("Add new Order with one orderstutus");


    }
}
