package com.gayathri.BookItNow.Controllers;

import com.gayathri.BookItNow.Model.TheatreModel;
import com.gayathri.BookItNow.Service.TheatreService;
import com.gayathri.BookItNow.exception.TheatreAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/theatre")
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    public ResponseEntity<TheatreModel> createTheatre(@RequestBody TheatreModel theatreModel) {
        TheatreModel createdTheatre = theatreService.createTheatre(theatreModel);
        return new ResponseEntity<>(createdTheatre, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<TheatreModel> getTheatreByName(@RequestParam String theatreName) {
        TheatreModel theatre = theatreService.getTheatreByName(theatreName);
        if (theatre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @ExceptionHandler(TheatreAlreadyExistsException.class)
    public ResponseEntity<String> handleTheatreAlreadyExists(TheatreAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
