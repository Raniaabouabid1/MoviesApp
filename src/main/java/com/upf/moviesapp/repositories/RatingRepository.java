package com.upf.moviesapp.repositories;

import com.upf.moviesapp.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query("SELECT SUM(r.rating) FROM Rating r WHERE r.movie.id = :movie_id")
    public int ratingSum(@Param("movie_id") Long movie_id);

    @Query("SELECT COUNT(*) FROM Rating r WHERE r.movie.id = :movie_id AND r.rating = :rating")
    public int countByRatingAndMovieId(@Param("movie_id") Long movie_id, @Param("rating") int rating);

    public Long countByMovieId(Long movie_id);

    public Rating getByUserIdAndMovieId(Long user_id, Long movie_id);
}
