package com.gayathri.BookItNow.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    @JsonProperty("movie_id")
    private String movieId;

    @JsonProperty("movie_name")
    private String movieName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("duration_minutes")
    private Integer durationMinutes;

    @JsonProperty("image")
    private String image;

    public Movie() {
    }

    public Movie(String movieId, String movieName, String description, Integer durationMinutes, String image) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.description = description;
        this.durationMinutes = durationMinutes;
        this.image = image;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
