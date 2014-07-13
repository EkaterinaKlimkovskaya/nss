package nss.db.dao;

import nss.db.entities.Numbers;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class NumbersDAOImpl implements NumbersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void throwExceptionIfObjectNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }
    }

    @Override
    public Numbers retrieve(BigInteger objId) {
        throwExceptionIfObjectNull(objId);
        return(Numbers) sessionFactory.getCurrentSession().get(Numbers.class, objId);
    }

    @Override
    public void update(Numbers obj) {
        throwExceptionIfObjectNull(obj);
        sessionFactory.getCurrentSession().update(obj);
    }

    @Override
    public void create(Numbers obj) {
        throwExceptionIfObjectNull(obj);
        sessionFactory.getCurrentSession().persist(obj);
    }

    @Override
    public void remove(BigInteger objId) {
        throwExceptionIfObjectNull(objId);
        Numbers object = retrieve(objId);
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Numbers> listNumbers() {
        return sessionFactory.getCurrentSession().createQuery("from Numbers").list();
    }
}
