package com.upf.moviesapp.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.upf.moviesapp.DTO.MovieDto;
import com.upf.moviesapp.entities.Genre;
import com.upf.moviesapp.entities.Movie;
import com.upf.moviesapp.repositories.GenreRepository;
import com.upf.moviesapp.repositories.MovieRepository;
import com.upf.moviesapp.services.GenreServiceImp;
import com.upf.moviesapp.services.MoviesServicesImp;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/editMovie")
public class EditMovieController {

    private final MovieRepository movieRep;
    private final GenreRepository genreRep;
    private Long movie_id;

    @Autowired
    public EditMovieController(MovieRepository movieRep, GenreRepository genreRep) {
        this.movieRep = movieRep;
        this.genreRep = genreRep;
    }

    @GetMapping
    public String editMoviePage (Model model, @RequestParam Long id) {

        MoviesServicesImp movieService = new MoviesServicesImp(movieRep);
        GenreServiceImp genreService = new GenreServiceImp(genreRep);
        try {
            movie_id = id;
            Movie movie = movieService.getMovieById(id);

            model.addAttribute("movie",movie);
            MovieDto movieDto = new MovieDto();
            movieDto.setId(id);
            movieDto.setTitle(movie.getTitle());
            movieDto.setCast(movie.getCast());
            movieDto.setDescription(movie.getDescription());
            movieDto.setDirector(movie.getDirector());
            movieDto.setLength(movie.getLength());
            movieDto.setRevenue(movie.getRevenue());
            movieDto.setReleasedate(movie.getReleasedate());
            model.addAttribute("movieDto",movieDto);
            List<Genre> genres = genreService.getAllGenres();
            model.addAttribute("genres", genres);
        }catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());
            return "redirect:/adminMovies";
        }
        return "adminMovies/EditMovie";
    }

    @PostMapping
    public String updateMovie(Model model,
                              @Validated
                              @ModelAttribute MovieDto movieDto,BindingResult result) {

        MoviesServicesImp movieService = new MoviesServicesImp(movieRep);
        GenreServiceImp genreService = new GenreServiceImp(genreRep);

        try {
            Movie movie = movieService.getMovieById(movie_id);

            model.addAttribute("movie",movie);

            if(result.hasErrors()) {
                return "adminMovies/EditMovie";
            }

            if (!movieDto.getPoster().isEmpty() && !movieDto.getPanoramic_poster().isEmpty()) {

                String uploadDir = "/images/";

                MultipartFile image = movieDto.getPoster();
                MultipartFile image2 = movieDto.getPanoramic_poster();

                String storageFilename = uploadDir + image.getOriginalFilename();
                String storageFilename2 = uploadDir + image2.getOriginalFilename();

                try (InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream, Paths.get("src/main/resources/static" + storageFilename),
                            StandardCopyOption.REPLACE_EXISTING);
                }

                try (InputStream inputStream = image2.getInputStream()) {
                    Files.copy(inputStream, Paths.get("src/main/resources/static" + storageFilename2),
                            StandardCopyOption.REPLACE_EXISTING);
                }

                movie.setPoster(storageFilename);
                movie.setPanoramicPoster(storageFilename2);
                System.out.println(movie.getPoster());
                System.out.println(movie.getPanoramicPoster());
            }


            movie.setTitle(movieDto.getTitle());
            movie.setLength(movieDto.getLength());
            movie.setReleasedate(movieDto.getReleasedate());
            movie.setDirector(movieDto.getDirector());
            movie.setCast(movieDto.getCast());
            movie.setRevenue(movieDto.getRevenue());
            movie.setDescription(movieDto.getDescription());

            List<Genre> genres = genreService.findGenresByIds(movieDto.getGenreIds());
            movie.setGenres(genres);
            movieService.saveMovie(movie);
        } catch (Exception e) {
            System.out.println("Exception2: " + e.getMessage());
        }
        return "redirect:/adminMovies";
    }
}
