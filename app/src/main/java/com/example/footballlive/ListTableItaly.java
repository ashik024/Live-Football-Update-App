package com.example.footballlive;

class ListTableItaly {
    public String positionI;
    public String teamI;
    public String playedI;
    public String wonI;
    public String drawI;
    public String lostI;
    public String gdI;
    public String ptsI;
    public String seasonI;

    public ListTableItaly(String positionI, String teamI, String playedI, String wonI, String drawI, String lostI, String gdI, String ptsI, String seasonI) {
        this.positionI = positionI;
        this.teamI = teamI;
        this.playedI = playedI;
        this.wonI = wonI;
        this.drawI = drawI;
        this.lostI = lostI;
        this.gdI = gdI;
        this.ptsI = ptsI;
        this.seasonI = seasonI;
    }

    public String getPositionI() {
        return positionI;
    }

    public String getTeamI() {
        return teamI;
    }

    public String getPlayedI() {
        return playedI;
    }

    public String getWonI() {
        return wonI;
    }

    public String getDrawI() {
        return drawI;
    }

    public String getLostI() {
        return lostI;
    }

    public String getGdI() {
        return gdI;
    }

    public String getPtsI() {
        return ptsI;
    }

    public String getSeasonI() {
        return seasonI;
    }
}
