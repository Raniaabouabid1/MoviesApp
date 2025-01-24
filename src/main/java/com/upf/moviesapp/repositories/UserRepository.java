package com.upf.moviesapp.repositories;

import com.upf.moviesapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.id = :user_id")
    public User getById(@Param("user_id") Long user_id);

    User findByEmail (String email);
}