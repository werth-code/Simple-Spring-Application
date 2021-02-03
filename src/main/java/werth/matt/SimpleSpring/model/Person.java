package werth.matt.SimpleSpring.model;

public class Person {
    private Long id;
    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(){};

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
