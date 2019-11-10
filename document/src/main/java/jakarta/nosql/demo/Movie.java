package jakarta.nosql.demo;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.util.List;
import java.util.Map;

@Entity
public class Movie {

    @Id
    private String id;

    @Column
    private String title;

    @Column
    private String plot;

    @Column
    private Integer year;

    private List<Actor> actors;

    public void update(Movie movie) {
        this.title = movie.title;
        this.plot = movie.plot;
        this.plot = movie.plot;
        this.year = movie.year;
        this.actors = movie.actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", plot='" + plot + '\'' +
                ", year=" + year +
                ", actors=" + actors +
                '}';
    }
}
