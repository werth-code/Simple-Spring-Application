package werth.matt.SimpleSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import werth.matt.SimpleSpring.model.Person;
import werth.matt.SimpleSpring.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String basic() {
        return "hi";
    }

    @GetMapping("/greeting")
    public Person greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Person(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/person")
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/person")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }
}
