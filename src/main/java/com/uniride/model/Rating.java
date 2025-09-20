
package com.uniride.model;

import com.uniride.enums.RatingType;

import java.time.LocalDateTime;

public class Rating {
    private String ratingId;
    private String tripId;
    private String raterId;
    private String ratedUserId;
    private int score;
    private String comment;
    private RatingType ratingType;
    private LocalDateTime timestamp;

    public void submitRating() {}
    public void reportUser() {}
    public void updateRating() {}

    // Getters and Setters

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getRaterId() {
        return raterId;
    }

    public void setRaterId(String raterId) {
        this.raterId = raterId;
    }

    public String getRatedUserId() {
        return ratedUserId;
    }

    public void setRatedUserId(String ratedUserId) {
        this.ratedUserId = ratedUserId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public void setRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
