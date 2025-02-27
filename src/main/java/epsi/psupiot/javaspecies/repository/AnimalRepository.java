package epsi.psupiot.javaspecies.repository;

import epsi.psupiot.javaspecies.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpeciesId(Integer speciesId);

    List<Animal> findByColorIn(List<String> colors);

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex LIKE %?1%")
    Integer countBySex(String sex);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM Person p JOIN p.animals a WHERE a.id = ?1")
    Boolean isOwned(Integer animalId);
}
