package com.upf.moviesapp.entities;


import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "users" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String f_name;
    private String l_name;
    private String email;
    private String password;


    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<Rating> ratings;

    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<Review> reviews;

    @OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<Post> posts;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id"))
    private Collection<Role> roles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User() {}



    public User(String f_name, String l_name, String email, String password, Collection<Role> roles) {
        super();
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", f_name=" + f_name + ", l_name=" + l_name + ", email=" + email + ", password="
                + password + ", ratings=" + ratings + ", reviews=" + reviews + ", posts=" + posts + ", roles=" + roles
                + "]";
    }


}
