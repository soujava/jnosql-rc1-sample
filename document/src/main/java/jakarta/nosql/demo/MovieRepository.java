package jakarta.nosql.demo;

import jakarta.nosql.mapping.Repository;

import java.util.List;

public interface MovieRepository extends Repository<Movie, String> {

    List<Movie> findAll();
}
