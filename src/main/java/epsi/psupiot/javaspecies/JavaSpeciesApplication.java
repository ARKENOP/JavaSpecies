package epsi.psupiot.javaspecies;

import epsi.psupiot.javaspecies.model.Animal;
import epsi.psupiot.javaspecies.model.Person;
import epsi.psupiot.javaspecies.model.Role;
import epsi.psupiot.javaspecies.model.Species;
import epsi.psupiot.javaspecies.repository.AnimalRepository;
import epsi.psupiot.javaspecies.repository.PersonRepository;
import epsi.psupiot.javaspecies.repository.RoleRepository;
import epsi.psupiot.javaspecies.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class JavaSpeciesApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaSpeciesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Afficher la liste des entités avec findAll
        System.out.println("Animals: " + animalRepository.findAll());
        System.out.println("Persons: " + personRepository.findAll());
        System.out.println("Roles: " + roleRepository.findAll());
        System.out.println("Species: " + speciesRepository.findAll());

        //Créer quelques entités avec la méthode save
        Species species = new Species();
        species.setCommonName("Chien");
        species.setLatinName("canem");
        speciesRepository.save(species);

        Person person = new Person();
        person.setFirstname("Paul");
        person.setLastname("Supiot");
        person.setAge(20);
        person.setLogin("psupiot");
        person.setMdp("epsi");
        person.setActive(true);
        personRepository.save(person);

        Role role = new Role();
        role.setLabel("ROLE_ADMIN");
        roleRepository.save(role);

        //Rechercher une entité par son id avec findById
        Optional<Species> foundSpecies = speciesRepository.findById(1);
        System.out.println("Espèces trouvée: " + foundSpecies);

        //Supprimer une entité avec delete, et afficher la longueur de la liste de toutes les entités
        speciesRepository.deleteById(4);
        System.out.println("Nombre d'animaux après le delete: " + speciesRepository.findAll().size());

    }
}
