package nss.helpers;

import nss.db.entities.Numbers;
import nss.db.services.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.TreeSet;

public class NumbersStoringHelper {

    @Autowired
    private NumbersService numbersService;

    public void addNumberToDB(Long number) {
        numbersService.create(new Numbers(number));
    }

    public Set<Long> getStoredNumbersFromDB() {
        Set<Long> numbers = new TreeSet<Long>();
        for (Numbers number : numbersService.listNumbers()) {
            numbers.add(number.getNumber());
        }
        return numbers;
    }

}
