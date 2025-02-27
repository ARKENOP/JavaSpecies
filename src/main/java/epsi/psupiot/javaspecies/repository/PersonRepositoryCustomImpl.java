package epsi.psupiot.javaspecies.repository;

import epsi.psupiot.javaspecies.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void deleteAllWithoutAnimals() {
        entityManager.createQuery("DELETE FROM Person p WHERE p.animals IS EMPTY")
                .executeUpdate();
    }

    @Override
    @Transactional
    public void generateRandomPersons(int count) {
        for (int i = 0; i < count; i++) {
            Person person = new Person();
            person.setFirstname("Jack");
            person.setLastname("Lagrange" + i);
            person.setAge((int) (Math.random() * 100));
            person.setLogin(RandomStringUtils.randomAlphanumeric(3));
            person.setMdp(RandomStringUtils.randomAlphanumeric(8));
            person.setActive(true);
            entityManager.persist(person);
        }
    }
}
