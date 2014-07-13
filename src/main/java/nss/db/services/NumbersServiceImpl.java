package nss.db.services;

import nss.db.dao.NumbersDAO;
import nss.db.entities.Numbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
public class NumbersServiceImpl implements NumbersService {

    @Autowired
    private NumbersDAO numbersDAO;

    @Override
    @Transactional
    public Numbers retrieve(BigInteger objId) {
        return numbersDAO.retrieve(objId);
    }

    @Override
    @Transactional
    public void update(Numbers obj) {
        numbersDAO.update(obj);
    }

    @Override
    @Transactional
    public void create(Numbers obj) {
        numbersDAO.create(obj);
    }

    @Override
    @Transactional
    public void remove(BigInteger objId) {
        numbersDAO.remove(objId);
    }

    @Override
    @Transactional
    public List<Numbers> listNumbers() {
        return numbersDAO.listNumbers();
    }
}
