package epsi.psupiot.javaspecies.repository;

import epsi.psupiot.javaspecies.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
