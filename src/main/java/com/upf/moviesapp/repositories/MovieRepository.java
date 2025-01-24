package com.upf.moviesapp.repositories;

import com.upf.moviesapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository  extends JpaRepository<Movie, Long> {
    @Query("SELECT DISTINCT m FROM Movie m JOIN m.genres g WHERE LOWER(g.genre) LIKE CONCAT('%', LOWER(:genre), '%')")
    List<Movie> findMoviesByGenre(@Param("genre") String genre);

    @Query("SELECT m FROM Movie m WHERE m.id = :movie_id")
    public Movie getById(@Param("movie_id") Long movie_id);

    @Query("SELECT m FROM Movie m JOIN m.ratings r WHERE r.rating >= 4")
    public List<Movie> findTrendingMovies();

    List<Movie> findByTitleIgnoreCaseContaining(String searchTerm);

    List<Movie> findByDirectorIgnoreCaseContaining(String searchTerm);

    List<Movie> findByCastIgnoreCaseContaining(String searchTerm);
}
