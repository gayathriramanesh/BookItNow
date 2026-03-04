package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Seat;
import com.gayathri.BookItNow.Model.SeatStatus;

import java.util.List;

public interface SeatService {

    List<Seat> createSeatsForShow(String screenId, String showId, int capacity);

    List<Seat> getSeatsByShowId(String showId);

    List<Seat> getAvailableSeatsByShowId(String showId);

    void updateSeatStatus(String seatId, String showId, SeatStatus status);
}

