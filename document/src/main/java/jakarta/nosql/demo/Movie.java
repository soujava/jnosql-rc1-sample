package jakarta.nosql.demo;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import javax.json.bind.annotation.JsonbVisibility;
import java.util.List;
import java.util.Map;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Movie {

    @Id
    private String id;

    @Column
    private String title;

    @Column
    private Integer year;

    @Column
    private List<Actor> actors;

    public void update(Movie movie) {
        this.title = movie.title;
        this.year = movie.year;
        this.actors = movie.actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", actors=" + actors +
                '}';
    }
}
