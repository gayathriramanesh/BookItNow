package com.gayathri.BookItNow.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Screen {

    @JsonProperty("screen_id")
    private String screenId;

    @JsonProperty("screen_name")
    private String screenName;

    @JsonProperty("screen_capacity")
    private Integer screenCapacity;

    public Screen() {
    }

    public Screen(String screenId, String screenName, Integer screenCapacity) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.screenCapacity = screenCapacity;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Integer getScreenCapacity() {
        return screenCapacity;
    }

    public void setScreenCapacity(Integer screenCapacity) {
        this.screenCapacity = screenCapacity;
    }
}
