package com.gayathri.BookItNow.Controllers;

import com.gayathri.BookItNow.Model.Seat;
import com.gayathri.BookItNow.Service.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/by-show")
    public ResponseEntity<List<Seat>> getSeatsByShow(@RequestParam String showId) {
        List<Seat> seats = seatService.getSeatsByShowId(showId);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/by-show/available")
    public ResponseEntity<List<Seat>> getAvailableSeatsByShow(@RequestParam String showId) {
        List<Seat> seats = seatService.getAvailableSeatsByShowId(showId);
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

