package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.TheatreModel;

public interface TheatreService {

    TheatreModel createTheatre(TheatreModel theatreModel);

    TheatreModel getTheatreByName(String theatreName);
}
