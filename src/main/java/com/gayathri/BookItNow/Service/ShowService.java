package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.ShowModel;

import java.util.List;

public interface ShowService {

    ShowModel createShow(ShowModel showModel);

    List<ShowModel> getAllShows();

    ShowModel getShowById(String showId);

    List<ShowModel> getShowsByMovieName(String movieName);

    List<ShowModel> getShowsByMovieId(String movieId);

    List<ShowModel> getShowsByScreenId(String screenId);
}
