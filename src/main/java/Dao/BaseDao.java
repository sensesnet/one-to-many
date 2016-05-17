package Dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by KIRILL on 08.05.2016.
 */
public class BaseDao<T> implements Dao<T> {

    private static Logger log = Logger.getLogger(BaseDao.class);
    private Transaction transaction = null;

    public void add(T t) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); //open session
            session.beginTransaction();                                // start transaction
            log.info(" - Start add method ");
            session.save(t);
            session.getTransaction().commit();                         //start commit

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error add <T> in Dao" + e);
        } finally {
            if ((session != null) && (session.isOpen())) {      //clean memory

                session.close();                  // close session
            }
        }
    }

    public void remove(T t) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); //open session
            session.beginTransaction();                                // start transaction
            log.info(" - Start remove method ");
            session.delete(t);
            session.getTransaction().commit();                         //start commit

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error remove <T> in Dao" + e);
        } finally {
            if ((session != null) && (session.isOpen())) {      //clean memory

                session.close();                   // close session
            }
        }
    }

    public T getById(Serializable id) throws SQLException {
        T result = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            log.info(" - Start getById method ");
            result = (T) session.get(getPersistentClass(),id);//load(getPersistentClass(),id);  // return object

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error getById <T> in Dao" + e);
        } finally {
            if ((session != null) && (session.isOpen())) {      //clean memory
                session.close();                   // close session
            }
            return result;
        }
    }

    public List<T> getAll() throws SQLException {

        List<T> result = null;
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            log.info(" - Start getAll method ");
            result = session.createCriteria(getPersistentClass()).list();  // return object

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error getAll <T> in Dao" + e);
        } finally {
            if ((session != null) && (session.isOpen())) {      //clean memory
                session.close();                   // close session
            }
            return result;
        }
    }

    public void edit(T t) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            log.info("edit(t):" + t);
            transaction.commit();
            log.info("edit(commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update PERSON in Dao" + e);
            transaction.rollback();
        }
    }



    private Class getPersistentClass() {    // return load class
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
