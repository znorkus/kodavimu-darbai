package lt.techin.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Actors")
public class Actor {

    @Id
    private long id;
    private String name;
    private int age;
    private int height;
    private long salary;

    public Actor(long id, String name, int age, int height, long salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.salary = salary;

    }

    public Actor() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public long getSalary() {
        return salary;
    }
}

