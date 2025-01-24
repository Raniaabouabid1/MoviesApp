package com.upf.moviesapp.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
@RequestMapping("/adminMovies")
public class AdminMovieController {

    private final  MovieRepository movieRep;
    private final GenreRepository genreRep;

    @Autowired
    public AdminMovieController(MovieRepository movieRep, GenreRepository genreRep) {
        this.movieRep = movieRep;
        this.genreRep = genreRep;
    }


    private final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";


    @GetMapping({"","/"})
    public String listMovies(Model model) {
        MoviesServicesImp movieService = new MoviesServicesImp(movieRep);
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "adminMovies/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        GenreServiceImp genreService = new GenreServiceImp(genreRep);
        model.addAttribute("movieDto", new MovieDto());
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "adminMovies/createMovie";
    }



    @PostMapping
    public String CreateMovie(
            @Validated @ModelAttribute MovieDto movieDto, BindingResult result) {

        if (movieDto.getPoster().isEmpty() || movieDto.getPanoramic_poster().isEmpty()) {
            result.addError(new FieldError("movieDto", "poster", "The poster image file is empty"));
            result.addError(new FieldError("movieDto", "panoramic_poster", "The panoramic_poster image file is empty"));
        }

        if (result.hasErrors()) {
            return "adminMovies/createMovie";
        }

        MultipartFile image = movieDto.getPoster();
        MultipartFile image2 = movieDto.getPanoramic_poster();

        try {
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String uniqueFilename1 = saveImage(image, uploadPath);
            String uniqueFilename2 = saveImage(image2, uploadPath);

            GenreServiceImp genreService = new GenreServiceImp(genreRep);
            MoviesServicesImp movieService = new MoviesServicesImp(movieRep);

            Movie movie = new Movie();
            movie.setTitle(movieDto.getTitle());
            movie.setLength(movieDto.getLength());
            movie.setReleasedate(movieDto.getReleasedate());
            movie.setDirector(movieDto.getDirector());
            movie.setCast(movieDto.getCast());
            movie.setRevenue(movieDto.getRevenue());
            movie.setDescription(movieDto.getDescription());
            movie.setGenres(genreService.findGenresByIds(movieDto.getGenreIds()));
            movie.setPoster("/images/" + uniqueFilename1); // Web-accessible path
            movie.setPanoramicPoster("/images/" + uniqueFilename2);

            movieService.saveMovie(movie);

        } catch (IOException e) {
            e.printStackTrace();
            result.addError(new FieldError("movieDto", "poster", "Error saving the poster image"));
            result.addError(new FieldError("movieDto", "panoramic_poster", "Error saving the panoramic_poster image"));
            return "adminMovies/createMovie";
        }

        return "redirect:adminMovies";
    }

    private String saveImage(MultipartFile image, Path uploadPath) throws IOException {
        String originalFilename = image.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new IOException("Invalid file name");
        }

        String fileExtension = "";
        int dotIndex = originalFilename.lastIndexOf(".");
        if (dotIndex != -1) {
            fileExtension = originalFilename.substring(dotIndex);
        }

        String uniqueFilename = originalFilename.replace(fileExtension, "") + fileExtension;
        Path filePath = uploadPath.resolve(uniqueFilename);

        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }

        image.transferTo(filePath.toFile());
        return uniqueFilename;
    }

    @GetMapping("/delete")
    public String deleteMovie(@RequestParam Long id){
        GenreServiceImp genreService = new GenreServiceImp(genreRep);
        MoviesServicesImp movieService = new MoviesServicesImp(movieRep);

        try {
            Movie movie = movieService.getMovieById(id);

            Path imagePath = Paths.get(movie.getPoster());
            Path imagePath2 = Paths.get(movie.getPanoramicPoster());
            try {
                Files.delete(imagePath);
                Files.delete(imagePath2);
            }catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

            movie.setGenres(null);

            movieService.deleteMovieByObject(movie);

        }catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return "redirect:/adminMovies";
    }
}
