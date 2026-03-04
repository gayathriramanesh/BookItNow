package com.gayathri.BookItNow.Service;

import com.gayathri.BookItNow.Model.Seat;
import com.gayathri.BookItNow.Model.SeatStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {

    private final List<Seat> seats = new ArrayList<>();

    @Override
    public List<Seat> createSeatsForShow(String screenId, String showId, int capacity) {
        if (screenId == null || showId == null || capacity <= 0) {
            return List.of();
        }

        List<Seat> existing = getSeatsByShowId(showId);
        if (!existing.isEmpty()) {
            return existing;
        }

        List<Seat> created = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            String seatNo = "S" + i;
            String seatId = screenId + "-" + showId + "-" + seatNo;
            Seat seat = new Seat(seatId, screenId, showId, seatNo, SeatStatus.AVAILABLE);
            seats.add(seat);
            created.add(seat);
        }
        return created;
    }

    @Override
    public List<Seat> getSeatsByShowId(String showId) {
        if (showId == null) {
            return List.of();
        }
        return seats.stream()
                .filter(seat -> showId.equals(seat.getShowId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Seat> getAvailableSeatsByShowId(String showId) {
        if (showId == null) {
            return List.of();
        }
        return seats.stream()
                .filter(seat -> showId.equals(seat.getShowId()) && seat.getStatus() == SeatStatus.AVAILABLE)
                .collect(Collectors.toList());
    }

    @Override
    public void updateSeatStatus(String seatId, String showId, SeatStatus status) {
        if (seatId == null || showId == null || status == null) {
            return;
        }
        seats.stream()
                .filter(seat -> seatId.equals(seat.getSeatId()) && showId.equals(seat.getShowId()))
                .findFirst()
                .ifPresent(seat -> seat.setStatus(status));
    }
}

