package nss.helpers;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class DataCache {

    @Autowired
    private NumbersStoringHelper numbersStoringHelper;

    private Set<Long> storedNumbers;

    public void initCache() {
        setStoredNumbers(numbersStoringHelper.getStoredNumbersFromDB());
    }

    public Set<Long> getStoredNumbers() {
        return this.storedNumbers;
    }

    public void setStoredNumbers(Set<Long> storedNumbers) {
        this.storedNumbers = storedNumbers;
    }

    public void addNumberToCache(Long number) {
        this.storedNumbers.add(number);
    }

    public void addNumberToDBAndCache(Long number) {
        numbersStoringHelper.addNumberToDB(number);
        addNumberToCache(number);
    }

    public void clearCache() {
        this.storedNumbers.clear();
    }

    public void refreshCache() {
        setStoredNumbers(numbersStoringHelper.getStoredNumbersFromDB());
    }
}
