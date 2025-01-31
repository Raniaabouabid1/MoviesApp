package com.upf.moviesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.repositories.MovieRepository;
import com.upf.moviesapp.repositories.RatingRepository;
import com.upf.moviesapp.repositories.UserRepository;
import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardRestController {

    private final UserRepository userRepo;
    private final RatingRepository ratingRepo;
    private final MovieRepository movieRepo;

    public DashboardRestController(UserRepository userRepo,
                                   RatingRepository ratingRepo,
                                   MovieRepository movieRepo) {
        this.userRepo = userRepo;
        this.ratingRepo = ratingRepo;
        this.movieRepo = movieRepo;
    }

    @GetMapping
    public Map<String, Object> getDashboardData() {
        Map<String, Object> response = new HashMap<>();

        long totalUsers = userRepo.count();
        response.put("totalUsers", totalUsers);

        long totalReviews = ratingRepo.count();
        response.put("totalReviews", totalReviews);

        double avgRating = ratingRepo.findAverageRating().orElse(0.0);
        response.put("avgRating", avgRating);

        Long[] distribution = {
                ratingRepo.countByRating(1),
                ratingRepo.countByRating(2),
                ratingRepo.countByRating(3),
                ratingRepo.countByRating(4),
                ratingRepo.countByRating(5)
        };
        response.put("ratingDistribution", distribution);

        Optional<Movie> bestMovie = movieRepo.findMovieWithHighestAverageRating();
        response.put("bestRatedMovie", bestMovie.map(Movie::getTitle).orElse("N/A"));

        Optional<Movie> worstMovie = movieRepo.findMovieWithLowestAverageRating();
        if (worstMovie.isPresent() && bestMovie.isPresent() &&
                worstMovie.get().getId().equals(bestMovie.get().getId())) {
            List<Movie> worstMovies =  movieRepo.findMoviesWithLowestRatingsExcluding(bestMovie.get().getId());
            response.put("worstRatedMovie", worstMovies.isEmpty() ? "N/A" : worstMovies.get(0).getTitle());
        } else {
            response.put("worstRatedMovie", worstMovie.map(Movie::getTitle).orElse("N/A"));
        }

        return response;
    }
}
