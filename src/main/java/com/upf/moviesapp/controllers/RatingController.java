package com.upf.moviesapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.upf.moviesapp.DTO.RatingRequest;
import com.upf.moviesapp.entities.Rating;
import com.upf.moviesapp.entities.User;
import com.upf.moviesapp.repositories.MovieRepository;
import com.upf.moviesapp.repositories.RatingRepository;
import com.upf.moviesapp.repositories.UserRepository;
import com.upf.moviesapp.security.CustomUserDetails;
import com.upf.moviesapp.services.RatingServicesImp;

@RestController
public class RatingController {

    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public RatingController(UserRepository userRepository, RatingRepository ratingRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(value = "/movie/rate", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveRating(@RequestBody RatingRequest rr, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        Long user_id = user.getId();
        Long movie_id = rr.getMovie_id();
        int rating = rr.getRating();

        Rating userRating = ratingRepository.getByUserIdAndMovieId(user_id, movie_id);
        if (userRating != null) {
            userRating.setRating(rating);
            ratingRepository.save(userRating);
            return ResponseEntity.ok("Success");
        }
        RatingServicesImp rsi = new RatingServicesImp(ratingRepository, userRepository, movieRepository);
        userRating = rsi.createRating(user_id, movie_id, rating);
        ratingRepository.save(userRating);
        return ResponseEntity.ok("Success");
    }
}

