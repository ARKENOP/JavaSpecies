package epsi.psupiot.javaspecies.repository;

import epsi.psupiot.javaspecies.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByLastnameOrFirstname(String lastname, String firstname);

    List<Person> findByAgeGreaterThanEqual(Integer age);

    @Query("SELECT p FROM Person p WHERE p.age >= ?1 AND p.age <= ?2")
    List<Person> findAllByAgeBetween(Integer ageMin, Integer ageMax);

    @Query("SELECT p FROM Person p JOIN p.animals a WHERE a.id = ?1")
    List<Person> findAllByAnimalId(Integer animalId);
}
