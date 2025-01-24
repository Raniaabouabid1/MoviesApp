package com.upf.moviesapp.controllers;

import com.upf.moviesapp.services.MoviesServicesImp;
import com.upf.moviesapp.services.RatingServicesImp;
import com.upf.moviesapp.services.ReviewServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.repositories.*;

@Controller
public class MovieController {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/movie")
    public String homePage(@RequestParam Long id, Model model) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            RatingServicesImp rsi = new RatingServicesImp(ratingRepository, userRepository, movieRepository);
            MoviesServicesImp msi = new MoviesServicesImp(movieRepository);
            ReviewServicesImp revsi = new ReviewServicesImp(reviewRepository, userRepository, movieRepository);

            model.addAttribute("movie", movie);
            model.addAttribute("rating", rsi.getRating(movie));
            model.addAttribute("similarMovies", msi.getSimilarMovies(movie));
            model.addAttribute("percent", rsi.getRatingPercentages(movie));
            model.addAttribute("totalRatings", (movie.getRatings()).size());
        }
        return "movie";
    }
}
