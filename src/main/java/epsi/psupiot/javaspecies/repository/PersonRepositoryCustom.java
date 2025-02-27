package epsi.psupiot.javaspecies.repository;

public interface PersonRepositoryCustom {
    void deleteAllWithoutAnimals();
    void generateRandomPersons(int count);
}
