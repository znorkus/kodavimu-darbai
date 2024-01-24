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
    private long userId;
    private String userName;
    private float userReviewRating;
    private String userReviewComment;

    public Review(Movie movie, long userId, String userName, float userReviewRating,
                  String userReviewComment) {
        this.movie = movie;
        this.userId = userId;
        this.userName = userName;
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

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
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

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserReviewRating(float userReviewRating) {
        this.userReviewRating = userReviewRating;
    }

    public void setUserReviewComment(String userReviewComment) {
        this.userReviewComment = userReviewComment;
    }
}
