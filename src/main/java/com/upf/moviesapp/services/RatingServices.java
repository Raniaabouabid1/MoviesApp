package com.upf.moviesapp.services;

import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.entities.Rating;
import java.util.List;

public interface RatingServices {
    public int getTotalRating(List<Rating> ratings);
    public int getRating(Movie movie);
    public double[] getRatingPercentages(Movie movie);
    public Rating createRating(Long user_id, Long movie_id, int rating);
}
