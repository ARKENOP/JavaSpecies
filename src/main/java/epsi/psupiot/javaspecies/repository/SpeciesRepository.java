package epsi.psupiot.javaspecies.repository;

import epsi.psupiot.javaspecies.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findFirstByCommonName(String commonName);

    List<Species> findAllByCommonName(String commonName);

    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllByCommonNameAsc();

    @Query("SELECT s FROM Species s WHERE s.commonName LIKE %?1%")
    List<Species> findAllByCommonNameLike(String commonName);
}
