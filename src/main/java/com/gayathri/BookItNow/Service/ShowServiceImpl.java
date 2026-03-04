package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Movie;
import com.gayathri.BookItNow.Model.Screen;
import com.gayathri.BookItNow.Model.ShowModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {

    private final List<ShowModel> shows = new ArrayList<>();
    private final MovieService movieService;
    private final ScreenService screenService;
    private final SeatService seatService;

    public ShowServiceImpl(MovieService movieService, ScreenService screenService, SeatService seatService) {
        this.movieService = movieService;
        this.screenService = screenService;
        this.seatService = seatService;
    }

    @Override
    public ShowModel createShow(ShowModel showModel) {
        try {
            if (showModel.getScreenId() == null || showModel.getScreenId().isBlank()) {
                throw new IllegalArgumentException("Screen ID is required");
            }
            if (showModel.getStartTime() == null) {
                throw new IllegalArgumentException("Start time is required");
            }
            if (showModel.getEndTime() == null) {
                throw new IllegalArgumentException("End time is required");
            }
            if (showModel.getEndTime().isBefore(showModel.getStartTime())) {
                throw new IllegalArgumentException("End time must be after start time");
            }
            if (showModel.getEndTime().isAfter(showModel.getStartTime().plusHours(2))) {
                throw new IllegalArgumentException("Show duration cannot exceed 2 hours");
            }
            if (showModel.getShowId() == null || showModel.getShowId().isBlank()) {
                showModel.setShowId(UUID.randomUUID().toString());
            }
            if (showModel.getMovieId() == null || showModel.getMovieId().isBlank()) {
                throw new IllegalArgumentException("Movie ID is required");

            }
            Movie movie = movieService.getMovieById(showModel.getMovieId());
            if (movie == null) {
                throw new IllegalArgumentException("Movie not found");
            }
            Screen screen_obj = screenService.getScreenById(showModel.getScreenId());
            if (screen_obj == null) {
                throw new IllegalArgumentException("Screen not found");
            }
            shows.add(showModel);

            String screenId = screen_obj.getScreenId();
            if (screenId != null) {
                if (screen_obj.getScreenCapacity() != null && screen_obj.getScreenCapacity() > 0) {
                    seatService.createSeatsForShow(screenId, showModel.getShowId(), screen_obj.getScreenCapacity());
                }
            }

            return showModel;
        }
        catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Failed to create show: " + e.getMessage());
            }
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

