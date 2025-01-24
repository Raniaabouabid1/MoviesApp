package com.upf.moviesapp.DTO;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class MovieDto {

    private Long id;

    private String title;

    private int length;

    private String releasedate;

    private String director;

    private String cast;

    private double revenue;

    private String description;

    private MultipartFile poster;

    private MultipartFile panoramic_poster;

    private List<Long> GenreIds;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getGenreIds() {
        return GenreIds;
    }

    public void setGenreIds(List<Long> genresIds) {
        GenreIds = genresIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getPoster() {
        return poster;
    }

    public void setPoster(MultipartFile poster) {
        this.poster = poster;
    }

    public MultipartFile getPanoramic_poster() {
        return panoramic_poster;
    }

    public void setPanoramic_poster(MultipartFile panoramic_poster) {
        this.panoramic_poster = panoramic_poster;
    }





}
