package com.upf.moviesapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.upf.moviesapp.DTO.ReviewRequest;
import com.upf.moviesapp.DTO.ReviewResponse;
import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.entities.Rating;
import com.upf.moviesapp.entities.Review;
import com.upf.moviesapp.entities.User;
import com.upf.moviesapp.repositories.MovieRepository;
import com.upf.moviesapp.repositories.RatingRepository;
import com.upf.moviesapp.repositories.ReviewRepository;
import com.upf.moviesapp.repositories.UserRepository;
import com.upf.moviesapp.security.CustomUserDetails;
import com.upf.moviesapp.services.MoviesServicesImp;
import com.upf.moviesapp.services.RatingServicesImp;
import com.upf.moviesapp.services.ReviewServicesImp;

@Controller
public class ReviewController {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/movie/review", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveReview(@RequestBody ReviewRequest rr, Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        Long user_id = user.getId();
        Long movie_id = rr.getMovie_id();
        int rating = rr.getRating();
        String review = rr.getReview();

        System.out.println("User id: " + user_id + "\nMovie id: " + movie_id + "\nRating: " + rating + "\nReview" + review);
        Rating userRating = ratingRepository.getByUserIdAndMovieId(user_id, movie_id);
        Review userReview = reviewRepository.getByUserIdAndMovieId(user_id, movie_id);

        if (userRating != null) {
            userRating.setRating(rating);
        } else {
            RatingServicesImp rsi = new RatingServicesImp(ratingRepository, userRepository, movieRepository);
            userRating = rsi.createRating(user_id, movie_id, rating);
        }
        ratingRepository.save(userRating);

        if (userReview != null) {
            userReview.setReview(review);
        } else {
            ReviewServicesImp rsi = new ReviewServicesImp(reviewRepository, userRepository, movieRepository);
            userReview = rsi.createReview(user_id, movie_id, review);
        }
        reviewRepository.save(userReview);

        return ResponseEntity.ok(new ReviewResponse("Success", user.getF_name(), user.getL_name()));
    }
}
