package com.upf.moviesapp.services;

import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.entities.Review;
import com.upf.moviesapp.entities.User;
import com.upf.moviesapp.repositories.MovieRepository;
import com.upf.moviesapp.repositories.ReviewRepository;
import com.upf.moviesapp.repositories.UserRepository;

public class ReviewServicesImp implements ReviewServices {
    private ReviewRepository reviewRep;
    private UserRepository userRep;
    private MovieRepository movieRep;

    public ReviewServicesImp(ReviewRepository reviewRep, UserRepository userRep, MovieRepository movieRep) {
        this.reviewRep = reviewRep;
        this.userRep = userRep;
        this.movieRep = movieRep;
    }

    @Override
    public int getTotalReviews(Movie movie) {
        return reviewRep.countByMovieId(movie.getId());
    }

    @Override
    public Review createReview(Long user_id, Long movie_id, String review) {
        User user = userRep.getById(user_id);
        Movie movie = movieRep.getById(movie_id);
        Review userReview = new Review();
        userReview.setUser(user);
        userReview.setMovie(movie);
        userReview.setReview(review);
        return userReview;
    }
}
