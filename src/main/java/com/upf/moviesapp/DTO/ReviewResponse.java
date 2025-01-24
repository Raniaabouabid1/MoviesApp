package com.upf.moviesapp.DTO;

import lombok.*;

@Data

public class ReviewResponse {
    private String status;
    private String f_name;
    private String l_name;
    private String review;
    private int rating;

    public ReviewResponse(String status, String f_name, String l_name) {
        super();
        this.status = status;
        this.f_name = f_name;
        this.l_name = l_name;
        this.review = review;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getF_name() {
        return f_name;
    }
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }
    public String getL_name() {
        return l_name;
    }

    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
}
