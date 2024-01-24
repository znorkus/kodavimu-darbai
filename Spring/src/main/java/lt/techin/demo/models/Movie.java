package lt.techin.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String director;
    private short yearRelease;
    private short lengthMinutes;

    public Movie(long id, String title, String director, short yearRelease,
                 short lengthMinutes) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.yearRelease = yearRelease;
        this.lengthMinutes = lengthMinutes;

    }

    public Movie() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public short getYearRelease() {
        return yearRelease;
    }

    public short getLengthMinutes() {
        return lengthMinutes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYearRelease(short yearRelease) {
        this.yearRelease = yearRelease;
    }

    public void setLengthMinutes(short lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }
}

