package com.example.footballlive;

import java.io.Serializable;

class ListHighlights implements Serializable {

    public String title1;
    public String title2;
    public String videoURL;


    public ListHighlights(String title1, String title2, String videoURL) {
        this.title1 = title1;
        this.title2 = title2;
        this.videoURL = videoURL;
    }

    public String getTitle1() {
        return title1;
    }

    public String getTitle2() {
        return title2;
    }

    public String getVideoURL() {
        return videoURL;
    }
}
