package com.upf.moviesapp.services;

import com.upf.moviesapp.entities.Movie;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface MoviesServices {
    public List<Movie> getSimilarMovies(Movie movie);
    public List<Movie> getAllMovies();
    public List<Movie> getTrendingMovies();
    public Movie saveMovie(Movie movie);
    public Movie getMovieById(Long id);
    public void deleteMovie(Long id);
    public void deleteMovieByObject(Movie movie);
    public List<Movie> findBySearchTerm(String searchTerm);
}
