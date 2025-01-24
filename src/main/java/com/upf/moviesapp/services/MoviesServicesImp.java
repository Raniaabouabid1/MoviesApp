package com.upf.moviesapp.services;

import com.upf.moviesapp.entities.Genre;
import com.upf.moviesapp.entities.Movie;
import  com.upf.moviesapp.repositories.MovieRepository;
import  com.upf.moviesapp.repositories.RatingRepository;
import  com.upf.moviesapp.repositories.UserRepository;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.stream.Collectors;

public class MoviesServicesImp implements MoviesServices{

    private MovieRepository movieRep;
    private RatingRepository ratingRep;
    private UserRepository userRep;

    public MoviesServicesImp(MovieRepository movieRepository) {
        this.movieRep = movieRepository;
    }

    public MoviesServicesImp(MovieRepository movieRep, RatingRepository ratingRep, UserRepository userRep) {
        this.movieRep = movieRep;
        this.ratingRep = ratingRep;
        this.userRep = userRep;
    }

    @Override
    public List<Movie> getSimilarMovies(Movie movie) {
        List<Genre> genres = movie.getGenres();
        ArrayList<Movie> similarMovies = new ArrayList<Movie>();

        for (Genre genre : genres) {
            List<Movie> movies = movieRep.findMoviesByGenre(genre.getGenre());
            similarMovies.addAll(movies);
        }

        return similarMovies.stream()
                .distinct()
                .filter(m -> m.getId() != movie.getId())
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRep.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<Movie> getTrendingMovies() {
        RatingServicesImp rsi = new RatingServicesImp(ratingRep, userRep, movieRep);
        List<Movie> trending = getAllMovies();

        Iterator<Movie> iterator = trending.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            int rating = rsi.getRating(movie);
            if (rating < 4) {
                iterator.remove();
            }
        }

        return trending;
    }
    @Override
    public Movie saveMovie(Movie movie) {
        return movieRep.save(movie);
    }
    @Override
    public Movie getMovieById(Long id) {
        return movieRep.findById(id).get();
    }
    @Override
    public void deleteMovie(Long id) {
        movieRep.deleteById(id);
    }
    @Override
    public void deleteMovieByObject(Movie movie) {
        movieRep.delete(movie);
    }

    @Override
    public List<Movie> findBySearchTerm(String searchTerm) {
        List<Movie> titleMatch = movieRep.findByTitleIgnoreCaseContaining(searchTerm);
        List<Movie> directorMatch = movieRep.findByDirectorIgnoreCaseContaining(searchTerm);
        List<Movie> castMatch = movieRep.findByCastIgnoreCaseContaining(searchTerm);
        List<Movie> genreMatch = movieRep.findMoviesByGenre(searchTerm);

        List<Movie> res = new ArrayList<Movie>();

        res.addAll(genreMatch);
        res.addAll(titleMatch);
        res.addAll(directorMatch);
        res.addAll(castMatch);

        Set<Movie> uniqueMovies = new LinkedHashSet<Movie>(res);
        List<Movie> deduplicatedList = new ArrayList<>(uniqueMovies);
        return deduplicatedList;
    }
}
