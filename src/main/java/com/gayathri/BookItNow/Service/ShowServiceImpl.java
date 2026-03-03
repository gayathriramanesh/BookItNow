package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Movie;
import com.gayathri.BookItNow.Model.ShowModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {

    private final List<ShowModel> shows = new ArrayList<>();
    private final MovieService movieService;

    public ShowServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public ShowModel createShow(ShowModel showModel) {
        shows.add(showModel);
        return showModel;
    }

    @Override
    public List<ShowModel> getAllShows() {
        return new ArrayList<>(shows);
    }

    @Override
    public ShowModel getShowById(String showId) {
        return shows.stream()
                .filter(show -> showId != null && showId.equals(show.getShowId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ShowModel> getShowsByMovieName(String movieName) {
        Movie movie = movieService.getMovieByName(movieName);
        if (movie == null) {
            return List.of();
        }
        return getShowsByMovieId(movie.getMovieId());
    }

    @Override
    public List<ShowModel> getShowsByMovieId(String movieId) {
        if (movieId == null) {
            return List.of();
        }
        return shows.stream()
                .filter(show -> movieId.equals(show.getMovieId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShowModel> getShowsByScreenId(String screenId) {
        if (screenId == null) {
            return List.of();
        }
        return shows.stream()
                .filter(show -> screenId.equals(show.getScreenId()))
                .collect(Collectors.toList());
    }
}
