package nss.db.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Numbers")
public class Numbers {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "number")
    private Long number;

    public Numbers() {
    }

    public Numbers(Long number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Numbers numbers = (Numbers) obj;
        if (id != null ? !id.equals(numbers.id) : numbers.id != null) {
            return false;
        }
        if (number != null ? !number.equals(numbers.number) : numbers.number != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
