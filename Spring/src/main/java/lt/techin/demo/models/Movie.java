package lt.techin.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 1, message = "Title should be at least 1 characters long")
    private String title;
    @NotNull
    @Size(min = 3, message = "Directors name should be at least 3 characters long")
    private String director;
    @NotNull
//    @Min(value = 1900, message = "Year release should not be older than 1900")
    private LocalDate dateRelease;
    @Min(value = 30, message = "Length minutes should not be lower than 30 minutes")
    private short lengthMinutes;

    public Movie(String title, String director, LocalDate dateRelease,
                 short lengthMinutes) {
        this.title = title;
        this.director = director;
        this.dateRelease = dateRelease;
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

    public LocalDate getDateRelease() {
        return dateRelease;
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

    public void setDateRelease(LocalDate dateRelease) {
        this.dateRelease = dateRelease;
    }

    public void setLengthMinutes(short lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }
}

