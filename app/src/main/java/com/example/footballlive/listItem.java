package com.example.footballlive;

class listItem {
    public String heading;
    public String description;
    public String heading2;
    public String heading3;
    public String imageURL;
    public String halfTime;

    public String homeFormation;
    public String awayFormation;
    public String hScore;
    public String aScore;
    public String cardH;
    public String cardA;
    public String lineupH;
    public String lineupA;
    public String subH;
    public String subA;

    public listItem(String heading, String description, String heading2, String heading3, String imageURL, String halfTime, String homeFormation, String awayFormation, String hScore, String aScore, String cardH, String cardA, String lineupH, String lineupA, String subH, String subA) {
        this.heading = heading;
        this.description = description;
        this.heading2 = heading2;
        this.heading3 = heading3;
        this.imageURL = imageURL;
        this.halfTime = halfTime;
        this.homeFormation = homeFormation;
        this.awayFormation = awayFormation;
        this.hScore = hScore;
        this.aScore = aScore;
        this.cardH = cardH;
        this.cardA = cardA;
        this.lineupH = lineupH;
        this.lineupA = lineupA;
        this.subH = subH;
        this.subA = subA;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getHeading2() {
        return heading2;
    }

    public String getHeading3() {
        return heading3;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getHalfTime() {
        return halfTime;
    }

    public String getHomeFormation() {
        return homeFormation;
    }

    public String getAwayFormation() {
        return awayFormation;
    }

    public String gethScore() {
        return hScore;
    }

    public String getaScore() {
        return aScore;
    }

    public String getCardH() {
        return cardH;
    }

    public String getCardA() {
        return cardA;
    }

    public String getLineupH() {
        return lineupH;
    }

    public String getLineupA() {
        return lineupA;
    }

    public String getSubH() {
        return subH;
    }

    public String getSubA() {
        return subA;
    }
}


