package com.upf.moviesapp.services;

import com.upf.moviesapp.DTO.UserRegistrationDto;
import com.upf.moviesapp.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServices extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}

