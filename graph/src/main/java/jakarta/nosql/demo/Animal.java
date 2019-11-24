package jakarta.nosql.demo;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import javax.json.bind.annotation.JsonbVisibility;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Animal {

    @Id
    private Long id;

    @Column
    private String name;

    public void update(Animal animal) {
        this.name = animal.name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
