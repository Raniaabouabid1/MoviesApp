package com.upf.moviesapp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.upf.moviesapp.entities.User;
import com.upf.moviesapp.security.CustomUserDetails;

@Controller
public class ProfileController {

    @GetMapping("/Profile")
    public String profile(Model model, Authentication authentication ) {

        authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() instanceof CustomUserDetails) {

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            User user = userDetails.getUser();

            model.addAttribute("user", user);
            model.addAttribute("firstname",user.getF_name());
            model.addAttribute("lastname",user.getL_name());
        }

        return "profile";
    }
}

