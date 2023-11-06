package com.example.videoweb.Model;

public class Match {
    private String id;
    private String league;
    private String time;
    private String homeTeam;
    private String homeLogo;
    private String vs;
    private String awayTeam;
    private String awayLogo;
    private String url;

    private String linkLivestream;

    private String linkchat;

    public Match(String id, String league, String time, String homeTeam, String homeLogo, String vs, String awayTeam, String awayLogo, String url, String linkLivestream, String linkchat) {
        this.id = id;
        this.league = league;
        this.time = time;
        this.homeTeam = homeTeam;
        this.homeLogo = homeLogo;
        this.vs = vs;
        this.awayTeam = awayTeam;
        this.awayLogo = awayLogo;
        this.url = url;
        this.linkLivestream = linkLivestream;
        this.linkchat = linkchat;
    }

    public String getId() {
        return id;
    }

    public String getLeague() {
        return league;
    }

    public String getTime() {
        return time;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getHomeLogo() {
        return homeLogo;
    }

    public String getVs() {
        return vs;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getAwayLogo() {
        return awayLogo;
    }

    public String getUrl() {
        return url;
    }

    public String getLinkLivestream() {
        return linkLivestream;
    }
    public String getLinkchat() { return linkchat;
    }
}
