package com.upf.moviesapp.repositories;

import com.upf.moviesapp.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public int countByMovieId(Long movie_id);
    public Review getByUserIdAndMovieId(Long user_id, Long movie_id);
}