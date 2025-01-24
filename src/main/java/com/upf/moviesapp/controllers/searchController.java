package com.upf.moviesapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.upf.moviesapp.repositories.MovieRepository;
import com.upf.moviesapp.services.MoviesServicesImp;

@Controller
@RequestMapping("/search")
public class searchController {

    @Autowired
    private MovieRepository movieRep;

    @GetMapping
    public String search(@RequestParam String searchTerm, Model model) {
        MoviesServicesImp msi = new MoviesServicesImp(movieRep);

        model.addAttribute("movies", msi.findBySearchTerm(searchTerm));

        return "searchResults";
    }
}

