package com.upf.moviesapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.upf.moviesapp.DTO.UserRegistrationDto;
import com.upf.moviesapp.services.UserServices;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserServices userService;

    public UserRegistrationController(UserServices userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        // 1) Check if user/email already exists.
        if (userService.userExistsByEmail(registrationDto.getEmail())) {
            // Redirect to /registration with a 'userExists' param if the user already exists.
            return "redirect:/registration?userExists=true";
        }

        // 2) Otherwise, save the new user.
        userService.save(registrationDto);

        // 3) Redirect to /login with 'regsuccess=true' to display a success message.
        return "redirect:/login?regsuccess=true";
    }


}