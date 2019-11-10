package jakarta.nosql.demo;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

@Entity
public class Actor {

    @Column
    private String name;

    @Column
    private String city;

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
