package com.upf.moviesapp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.repositories.MovieRepository;
import com.upf.moviesapp.repositories.RatingRepository;
import com.upf.moviesapp.repositories.UserRepository;
import com.upf.moviesapp.services.MoviesServicesImp;

@Controller
public class HomeController {

    private final MovieRepository movieRep;
    private final UserRepository userRep;
    private final RatingRepository ratingRep;

    @Autowired
    public HomeController(final MovieRepository movieRep, final UserRepository userRep, final RatingRepository ratingRep) {
        this.movieRep = movieRep;
        this.userRep = userRep;
        this.ratingRep = ratingRep;
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        MoviesServicesImp msi = new MoviesServicesImp(movieRep);
        List<Movie> movies = msi.getAllMovies();
        model.addAttribute("movies", movies);
        List<Movie> trendingMovies = msi.getTrendingMovies();
        model.addAttribute("trendingMovies", trendingMovies);
        return "home";
    }
}

