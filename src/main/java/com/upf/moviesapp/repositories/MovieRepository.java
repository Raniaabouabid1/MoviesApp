package com.upf.moviesapp.repositories;

import com.upf.moviesapp.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

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

    @Query("SELECT m FROM Movie m")
    Page<Movie> findAllPaged(Pageable pageable);

    @Query("SELECT m FROM Movie m " +
            "WHERE (:title = '' OR m.title LIKE %:title%) " +
            "  AND (:director = '' OR m.director LIKE %:director%)")
    Page<Movie> searchByTitleDirector(@Param("title") String title,
                                      @Param("director") String director,
                                      Pageable pageable);


    @Query("SELECT m FROM Movie m ORDER BY (SELECT AVG(r.rating) FROM Rating r WHERE r.movie = m) DESC LIMIT 1")
    Optional<Movie> findMovieWithLowestAverageRating();

    @Query("SELECT m FROM Movie m ORDER BY (SELECT AVG(r.rating) FROM Rating r WHERE r.movie = m) DESC LIMIT 1")
    Optional<Movie> findMovieWithHighestAverageRating();

    @Query("SELECT m FROM Movie m JOIN m.ratings r GROUP BY m.id ORDER BY AVG(r.rating) ASC")
    List<Movie> findMoviesWithLowestRatingsExcluding(@Param("excludedId") Long excludedId);
}
