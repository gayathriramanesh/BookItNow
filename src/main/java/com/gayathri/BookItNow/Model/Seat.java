package com.gayathri.BookItNow.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {

    @JsonProperty("seat_id")
    private String seatId;

    @JsonProperty("screen_id")
    private String screenId;

    @JsonProperty("show_id")
    private String showId;

    @JsonProperty("seat_no")
    private String seatNo;

    @JsonProperty("seat_status")
    private SeatStatus status;

    public Seat() {
    }

    public Seat(String seatId, String screenId, String showId, String seatNo, SeatStatus status) {
        this.seatId = seatId;
        this.screenId = screenId;
        this.showId = showId;
        this.seatNo = seatNo;
        this.status = status;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}

