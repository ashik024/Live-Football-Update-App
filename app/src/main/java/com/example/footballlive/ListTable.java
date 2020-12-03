package com.example.footballlive;

class ListTable {

    public String position;
    public String team;
    public String played;
    public String won;
    public String draw;
    public String lost;
    public String gd;
    public String pts;
    public String season;

    public ListTable(String position, String team, String played, String won, String draw, String lost, String gd, String pts, String season) {
        this.position = position;
        this.team = team;
        this.played = played;
        this.won = won;
        this.draw = draw;
        this.lost = lost;
        this.gd = gd;
        this.pts = pts;
        this.season = season;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public String getPlayed() {
        return played;
    }

    public String getWon() {
        return won;
    }

    public String getDraw() {
        return draw;
    }

    public String getLost() {
        return lost;
    }

    public String getGd() {
        return gd;
    }

    public String getPts() {
        return pts;
    }

    public String getSeason() {
        return season;
    }
}
