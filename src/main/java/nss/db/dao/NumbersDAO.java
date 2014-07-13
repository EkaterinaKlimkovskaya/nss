package nss.db.dao;

import nss.db.entities.Numbers;

import java.math.BigInteger;
import java.util.List;

public interface NumbersDAO {

    public Numbers retrieve(BigInteger objId);

    public void update(Numbers obj);

    public void create(Numbers obj);

    public void remove(BigInteger objId);

    public List<Numbers> listNumbers();

}
