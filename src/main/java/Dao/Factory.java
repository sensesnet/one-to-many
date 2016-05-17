package Dao;


public class Factory {

    private static Factory instanse = new Factory();

    public OrderDao orderDao;
    public OrderStatusDao orderStatusDao;

    private Factory() {
    }

    public static Factory getInstanse() {
        return Factory.instanse;
    }

    public OrderDao getOrderDao() {
        if (orderDao == null)
            orderDao = new OrderDao();
        return orderDao;

    }

    public OrderStatusDao getOrderStatusDao() {
        if (orderStatusDao == null) orderStatusDao = new OrderStatusDao();
        return orderStatusDao;
    }
}
