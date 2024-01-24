package lt.techin.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int movieId;
    private long userId;
    private String userName;
    private float userReviewRating;
    private String userReviewComment;

    public Review(int movieId, long userId, String userName, float UserReviwRating,
                  String userReviewComment) {
        this.movieId = movieId;
        this.userId = userId;
        this.userName = userName;
        this.userReviewRating = userReviewRating;
        this.userReviewComment - userReviewComment;
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
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

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
