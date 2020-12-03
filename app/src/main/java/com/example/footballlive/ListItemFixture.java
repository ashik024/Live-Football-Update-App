package com.example.footballlive;

class ListItemFixture {
    public String hometeam;
    public String awayteam;
    public String date;
    public String halftime;
    public String finalresult;
    public String league;
    public String homelogo;
    public String awaylogo;
    public String hgoalscorers;
    public String agoalscorers;

    public ListItemFixture(String hometeam, String awayteam, String date, String halftime, String finalresult, String league, String homelogo, String awaylogo, String hgoalscorers, String agoalscorers) {
        this.hometeam = hometeam;
        this.awayteam = awayteam;
        this.date = date;
        this.halftime = halftime;
        this.finalresult = finalresult;
        this.league = league;
        this.homelogo = homelogo;
        this.awaylogo = awaylogo;
        this.hgoalscorers = hgoalscorers;
        this.agoalscorers = agoalscorers;
    }

    public String getHometeam() {
        return hometeam;
    }

    public String getAwayteam() {
        return awayteam;
    }

    public String getDate() {
        return date;
    }

    public String getHalftime() {
        return halftime;
    }

    public String getFinalresult() {
        return finalresult;
    }

    public String getLeague() {
        return league;
    }

    public String getHomelogo() {
        return homelogo;
    }

    public String getAwaylogo() {
        return awaylogo;
    }

    public String getHgoalscorers() {
        return hgoalscorers;
    }

    public String getAgoalscorers() {
        return agoalscorers;
    }
}
