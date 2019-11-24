package jakarta.nosql.demo;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import javax.json.bind.annotation.JsonbVisibility;
import java.util.Set;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Hero {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Set<String> powers;

    public void update(Hero hero) {
        this.name = hero.name;
        this.powers = hero.powers;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", powers=" + powers +
                '}';
    }

}
