package com.gayathri.BookItNow.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TheatreModel {

    private Long id;

    @JsonProperty("theatre_id")
    private String theatreId;

    @JsonProperty("theatre_name")
    private String theatreName;

    @JsonProperty("theatre_location")
    private String theatreLocation;

    @JsonProperty("screens")
    private List<Screen> screens;

    public TheatreModel() {
    }

    public TheatreModel(Long id, String theatreId, String theatreName, String theatreLocation, List<Screen> screens) {
        this.id = id;
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.theatreLocation = theatreLocation;
        this.screens = screens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreLocation() {
        return theatreLocation;
    }

    public void setTheatreLocation(String theatreLocation) {
        this.theatreLocation = theatreLocation;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
