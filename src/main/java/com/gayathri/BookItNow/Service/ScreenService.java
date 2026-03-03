package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Screen;

public interface ScreenService {

    Screen createScreen(Screen screen);

    Screen getScreenById(String screenId);
}