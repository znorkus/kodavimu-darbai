package lt.techin.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "Movie_id")
    private Movie movie;
    private float userReviewRating;
    private String userReviewComment;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;

    public Review(Movie movie, User user, String userName, float userReviewRating,
                  String userReviewComment) {
        this.movie = movie;
        this.user = user;
        this.userReviewRating = userReviewRating;
        this.userReviewComment = userReviewComment;
    }

    public Review() {

    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public User getUser() {
        return user;
    }

    public float getUserReviewRating() {
        return userReviewRating;
    }

    public String getUserReviewComment() {
        return userReviewComment;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserReviewRating(float userReviewRating) {
        this.userReviewRating = userReviewRating;
    }

    public void setUserReviewComment(String userReviewComment) {
        this.userReviewComment = userReviewComment;
    }
}
