package epsi.psupiot.javaspecies.repository;

import epsi.psupiot.javaspecies.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
}
