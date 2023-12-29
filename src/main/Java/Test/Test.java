package Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String FINAL_STRING = "FINAL_STRING";
    public Test (){}
    public Long getId() {
        return id;
    }
    public String getFINAL_STRING() {
        return FINAL_STRING;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", FINAL_STRING='" + FINAL_STRING + '\'' +
                '}';
    }
}
