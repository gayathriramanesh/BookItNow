package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Movie;

import java.util.List;

public interface MovieService {

    Movie createMovie(Movie movie);

    List<Movie> getAllMovies();

    Movie getMovieByName(String movieName);

    Movie getMovieById(String movieId);
}
