package com.upf.moviesapp.services;

import com.upf.moviesapp.entities.Genre;
import java.util.List;

public interface GenreService {
    public List<Genre> getAllGenres();

    public Genre saveGenre(Genre genre);

    public Genre getGenreById(Long id);

    public void deleteGenre(Long id);

    public List<Genre> findGenresByIds(List<Long> ids);
}
