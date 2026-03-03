package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final List<Movie> movies = new ArrayList<>();

    @Override
    public Movie createMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    @Override
    public Movie getMovieByName(String movieName) {
        return movies.stream()
                .filter(movie -> movieName != null && movieName.equalsIgnoreCase(movie.getMovieName()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie getMovieById(String movieId) {
        return movies.stream()
                .filter(movie -> movieId != null && movieId.equals(movie.getMovieId()))
                .findFirst()
                .orElse(null);
    }
}
