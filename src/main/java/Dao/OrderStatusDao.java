package Dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by KIRILL on 16.05.2016.
 */
public class OrderStatusDao extends BaseDao {
    @Override
    public void add(Object o) throws SQLException {
        super.add(o);
    }

    @Override
    public void remove(Object o) throws SQLException {
        super.remove(o);
    }

    @Override
    public Object getById(Serializable id) throws SQLException {
        return super.getById(id);
    }

    @Override
    public List getAll() throws SQLException {
        return super.getAll();
    }

    @Override
    public void edit(Object o) throws SQLException {
        super.edit(o);
    }
}
