package com.upf.moviesapp.DTO;

import lombok.*;

@Data
public class ReviewRequest {
    private Long movie_id;
    private int rating;
    private String review;

    public ReviewRequest(Long movie_id, int rating, String review) {
        this.movie_id = movie_id;
    }
    public ReviewRequest() {}

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Long getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

}

