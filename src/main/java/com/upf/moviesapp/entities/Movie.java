package com.upf.moviesapp.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String director;
    private int length;
    private double revenue;
    private String poster;
    private String panoramicPoster;
    private String releasedate;
    private String cast;
    private String description;

    public Movie() {
    }
    public Movie(String title, String director, int length, double revenue, String poster, String panoramicPoster,
                 String releasedate, String cast, String description, List<Genre> genres) {
        super();
        this.title = title;
        this.director = director;
        this.length = length;
        this.revenue = revenue;
        this.poster = poster;
        this.panoramicPoster = panoramicPoster;
        this.releasedate = releasedate;
        this.cast = cast;
        this.description = description;
        this.genres = genres;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (
            name="movie-genre",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id")
    )
    private List<Genre> genres = new ArrayList<Genre>();

    @OneToMany(mappedBy="movie", fetch=FetchType.EAGER)
    private List<Rating> ratings;

    @OneToMany(mappedBy="movie", fetch=FetchType.EAGER)
    private List<Review> reviews;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setPanoramicPoster(String panoramicPoster) {
        this.panoramicPoster = panoramicPoster;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getPanoramicPoster() {
        return panoramicPoster;
    }

    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();

        for (Genre genre : genres)
            stb.append(genre.getGenre() + ", ");

        String genres = stb.substring(0, stb.length() - 2);

        return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", length=" + length + ", revenue="
                + revenue + ", poster=" + poster + ", releasedate=" + releasedate + ", cast=" + cast + ", description="
                + description + ", genres=" + genres + "]";
    }


    public String getHourLength() {
        int hours = length / 60;
        int remainingMinutes = length % 60;

        return hours + "h " + remainingMinutes + " min";
    }



    public String getPrimaryCast() {
        String[] cast = castArray();
        return cast[0] + "  >  " + cast[1] + "  >  " + cast[2];
    }

    public String[] castArray() {
        return cast.split("\s*[;,]\s*");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie otherMovie = (Movie) o;
        return Objects.equals(title, otherMovie.getTitle()) &&
                Objects.equals(director, otherMovie.getDirector()) &&
                Objects.equals(length, otherMovie.getLength()) &&
                Objects.equals(revenue, otherMovie.getRevenue()) &&
                Objects.equals(releasedate, otherMovie.getReleasedate()) &&
                Objects.equals(cast, otherMovie.getCast()) &&
                Objects.equals(description, otherMovie.getDescription());
    }
}

