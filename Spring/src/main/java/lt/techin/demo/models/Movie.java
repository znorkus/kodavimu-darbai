package lt.techin.demo.models;

public class Movie {

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
}