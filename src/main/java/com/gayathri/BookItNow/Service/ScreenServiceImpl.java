package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Screen;
import com.gayathri.BookItNow.Model.TheatreModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {

    private final TheatreService theatreService;
    private final List<Screen> screens = new ArrayList<>();

    public ScreenServiceImpl(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @Override
    public Screen createScreen(Screen screen) {
        String theatreId = screen.getTheatreId();
        try {
            if (theatreId == null || theatreId.isBlank()) {
                throw new IllegalArgumentException("Theatre ID is required");
            }
            TheatreModel theatre = theatreService.getTheatreById(theatreId);
            if (theatre == null) {
                throw new IllegalArgumentException("No theatre found for ID: " + theatreId);
            }
            screen.setTheatreId(theatreId);
            screens.add(screen);
            return screen;
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Failed to create screen: " + e.getMessage());
        }
    }

    @Override
    public Screen getScreenById(String screenId) {
        return screens.stream()
                .filter(screen -> screenId != null && screenId.equals(screen.getScreenId()))
                .findFirst()
                .orElse(null);
    }
}
