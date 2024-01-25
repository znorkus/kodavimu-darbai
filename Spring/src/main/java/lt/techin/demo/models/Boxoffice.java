package lt.techin.demo.models;

import jakarta.persistence.*;

@Entity
public class Boxoffice {

    @Id
    private long movieId;
    @OneToOne
    @JoinColumn(name = "Movie_Id")
    @MapsId
    private Movie movie;
    private float rating;
    private long domesticSales;
    private long internationalSales;

    public Boxoffice(Movie movie, float rating, long domesticSales,
                     long internationalSales) {
        this.movie = movie;
        this.rating = rating;
        this.domesticSales = domesticSales;
        this.internationalSales = internationalSales;
    }

    public Boxoffice() {

    }

    public long getMovieId() {
        return movieId;
    }

    public Movie getMovie() {
        return movie;
    }

    public float getRating() {
        return rating;
    }

    public long getDomesticSales() {
        return domesticSales;
    }

    public long getInternationalSales() {
        return internationalSales;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setDomesticSales(long domesticSales) {
        this.domesticSales = domesticSales;
    }

    public void setInternationalSales(long internationalSales) {
        this.internationalSales = internationalSales;
    }
}
