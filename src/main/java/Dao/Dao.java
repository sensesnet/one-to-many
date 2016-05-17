package Dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by KIRILL on 08.05.2016.
 */
public interface Dao<T> {

    public void add(T t) throws SQLException;

    public void remove(T t) throws SQLException;

    public T getById(Serializable id) throws SQLException;

    public List<T> getAll() throws SQLException;

    public void edit(T t) throws SQLException;

}
