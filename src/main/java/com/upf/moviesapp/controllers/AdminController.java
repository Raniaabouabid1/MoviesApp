package com.upf.moviesapp.controllers;

import com.upf.moviesapp.entities.User;
import com.upf.moviesapp.security.CustomUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String adminHome(Model model, Authentication authentication) {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();

        model.addAttribute("username", user.getEmail());
        model.addAttribute("firstname", user.getF_name());
        model.addAttribute("lastname", user.getL_name());
        model.addAttribute("ID", user.getId());

        return "admin/homeAdmin";
    }
}