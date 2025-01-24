package com.upf.moviesapp.services;

import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.entities.Review;

public interface ReviewServices {
    public int getTotalReviews(Movie movie);
    public Review createReview(Long user_id, Long movie_id, String review);
}

