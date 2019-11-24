package jakarta.nosql.demo;

import jakarta.nosql.mapping.Repository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends Repository<Animal, Long> {

    List<Animal> findAll();

    Optional<Animal> findByName(String name);
}
