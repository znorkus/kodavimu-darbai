package lt.techin.demo.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int director_id;
    private int movie_id;
    private String name;
    private int age;

    public Director(int director_id, int movie_id, String name, int age) {
        this.director_id = director_id;
        this.movie_id = movie_id;
        this.name = name;
        this.age = age;
    }

    public Director() {
    }

    public int getDirector_id() {
        return director_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

