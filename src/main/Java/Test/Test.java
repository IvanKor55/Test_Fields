package Test;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    public void setFINAL_STRING(String FINAL_STRING) {
//        this.FINAL_STRING = FINAL_STRING;
//    }

    @Column(name = "FINAL_STRING")
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
