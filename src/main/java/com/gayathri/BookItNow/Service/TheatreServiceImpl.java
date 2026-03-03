package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.TheatreModel;
import com.gayathri.BookItNow.exception.TheatreAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final List<TheatreModel> theatres = new ArrayList<>();

    @Override
    public TheatreModel createTheatre(TheatreModel theatreModel) {
        if (getTheatreByName(theatreModel.getTheatreName()) != null) {
            throw new TheatreAlreadyExistsException("Theatre with this name already exists");
        }
        theatres.add(theatreModel);
        return theatreModel;
    }

    @Override
    public TheatreModel getTheatreByName(String theatreName) {
        return theatres.stream()
                .filter(theatre -> theatreName != null && theatreName.equalsIgnoreCase(theatre.getTheatreName()))
                .findFirst()
                .orElse(null);
    }
}
