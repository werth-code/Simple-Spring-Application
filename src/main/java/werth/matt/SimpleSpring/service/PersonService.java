package werth.matt.SimpleSpring.service;

import org.springframework.stereotype.Service;
import werth.matt.SimpleSpring.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {

    //This is only instantiated when we create a new instance of this class.
    public List<Person> people = new ArrayList<>(Arrays.asList(
            new Person(1L, "Matt"),
            new Person(2L, "Laurie")
    ));

    public List<Person> getPeople() {
        return people;
    }

    public Person getPersonById(Long id) {
        return people.stream().filter(person -> person.getId() == id).findFirst().get();
    }

    public void addPerson(Person person) {
        people.add(person);
    }
}
