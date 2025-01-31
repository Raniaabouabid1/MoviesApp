package com.upf.moviesapp.services;

import java.util.Arrays;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.upf.moviesapp.DTO.UserRegistrationDto;
import com.upf.moviesapp.entities.Role;
import com.upf.moviesapp.entities.User;
import com.upf.moviesapp.repositories.UserRepository;
import com.upf.moviesapp.security.CustomUserDetails;

@Service
public class UserServiceImp implements UserServices {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean userExistsByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstname(),
                registrationDto.getLastname(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new CustomUserDetails(user);
    }
}