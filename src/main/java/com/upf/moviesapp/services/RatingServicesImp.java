package com.upf.moviesapp.services;

import java.util.List;
import com.upf.moviesapp.entities.Rating;
import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.entities.User;
import com.upf.moviesapp.repositories.RatingRepository;
import com.upf.moviesapp.repositories.UserRepository;
import com.upf.moviesapp.repositories.MovieRepository;

public class RatingServicesImp implements RatingServices {
    private RatingRepository ratingRep;
    private UserRepository userRep;
    private MovieRepository movieRep;

    public RatingServicesImp(
            RatingRepository ratingRepository,
            UserRepository userRepository,
            MovieRepository movieRepository
    ) {
        ratingRep = ratingRepository;
        userRep = userRepository;
        movieRep = movieRepository;
    }

    @Override
    public int getRating(Movie movie) {
        int movieRating;
        List<Rating> ratings = movie.getRatings();
        int total_rating = getTotalRating(ratings);

        try {
            movieRating = (int)(total_rating/ratings.size());
            return movieRating;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int getTotalRating(List<Rating> ratings) {
        int total_rating = 0;

        for (Rating rating : ratings)
            total_rating += rating.getRating();

        return total_rating;
    }

    @Override
    public double[] getRatingPercentages(Movie movie) {
        int total_movie_ratings = (movie.getRatings()).size();
        double[] percentages = new double[5];
        double percentage;
        int rating = 5;
        for (int i = 0; i < 5; i++) {
            try {
                percentage = (ratingRep.countByRatingAndMovieId(movie.getId(), rating--) * 100)/total_movie_ratings;
            } catch (Exception e) {
                percentage = 0;
            }
            percentages[i] = percentage;
        }
        return percentages;
    }

    @Override
    public Rating createRating(Long user_id, Long movie_id, int rating) {
        User user = userRep.getById(user_id);
        Movie movie = movieRep.getById(movie_id);
        Rating userRating = new Rating();
        userRating.setUser(user);
        userRating.setMovie(movie);
        userRating.setRating(rating);
        return userRating;
    }

}
