package com.upf.moviesapp.DTO;

import lombok.*;

@Data
public class RatingRequest {
    private Long movie_id;
    private int rating;

    public RatingRequest(Long movie_id, int rating) {
        this.movie_id = movie_id;
        this.rating = rating;
    }
    public RatingRequest() {}

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public Long getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

}
