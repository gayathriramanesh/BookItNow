package com.gayathri.BookItNow.Controllers;

import com.gayathri.BookItNow.Model.ShowModel;
import com.gayathri.BookItNow.Service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/show")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public ResponseEntity<ShowModel> createShow(@RequestBody ShowModel showModel) {
        ShowModel createdShow = showService.createShow(showModel);
        return new ResponseEntity<>(createdShow, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShowModel>> getAllShows() {
        List<ShowModel> shows = showService.getAllShows();
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/{showId}")
    public ResponseEntity<ShowModel> getShowById(@PathVariable String showId) {
        ShowModel show = showService.getShowById(showId);
        if (show == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(show, HttpStatus.OK);
    }

    @GetMapping("/searcha")
    public ResponseEntity<List<ShowModel>> getShowsByMovieName(@RequestParam String movieName) {
        List<ShowModel> shows = showService.getShowsByMovieName(movieName);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/by-movie")
    public ResponseEntity<List<ShowModel>> getShowsByMovieId(@RequestParam String movieId) {
        List<ShowModel> shows = showService.getShowsByMovieId(movieId);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }

    @GetMapping("/by-screen")
    public ResponseEntity<List<ShowModel>> getShowsByScreenId(@RequestParam String screenId) {
        List<ShowModel> shows = showService.getShowsByScreenId(screenId);
        return new ResponseEntity<>(shows, HttpStatus.OK);
    }
}
