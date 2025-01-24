package com.upf.moviesapp.services;

import com.upf.moviesapp.entities.Genre;
import com.upf.moviesapp.repositories.GenreRepository;
import java.util.List;

public class GenreServiceImp implements GenreService {

    private GenreRepository genreRepository;

    public GenreServiceImp(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<Genre> findGenresByIds(List<Long> ids) {
        return genreRepository.findAllById(ids);
    }
}
