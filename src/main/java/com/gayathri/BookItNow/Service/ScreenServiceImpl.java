package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Screen;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {

    private final List<Screen> screens = new ArrayList<>();

    @Override
    public Screen createScreen(Screen screen) {
        screens.add(screen);
        return screen;
    }

    @Override
    public Screen getScreenById(String screenId) {
        return screens.stream()
                .filter(screen -> screenId != null && screenId.equals(screen.getScreenId()))
                .findFirst()
                .orElse(null);
    }
}
