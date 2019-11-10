package jakarta.nosql.demo;

import jakarta.nosql.mapping.Repository;

import java.util.List;

public interface HeroRepository extends Repository<Hero, String> {
    List<Hero> findAll();
}
