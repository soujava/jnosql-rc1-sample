package jakarta.nosql.demo;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;

import javax.json.bind.annotation.JsonbVisibility;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Actor {

    @Column
    private String name;

    @Column
    private String character;

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", character='" + character + '\'' +
                '}';
    }
}
