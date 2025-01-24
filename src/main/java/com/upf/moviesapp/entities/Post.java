package com.upf.moviesapp.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.*;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name="movie_1_id")
    private Movie movie1;

    @ManyToOne
    @JoinColumn(name="movie_2_id")
    private Movie movie2;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Movie getMovie1() {
        return movie1;
    }
    public void setMovie1(Movie movie1) {
        this.movie1 = movie1;
    }
    public Movie getMovie2() {
        return movie2;
    }
    public void setMovie2(Movie movie2) {
        this.movie2 = movie2;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
