package com.detroitlabs.fantasybball.model;

public class SeasonStatsObject {

    //used in SeasonStatRepository

    private int games_played;
    private int player_id;
    private String min;
    private double reb;
    private double ast;
    private double stl;
    private double blk;
    private double pts;

    public SeasonStatsObject(int games_played, int player_id, double reb, double ast, double stl, double blk, double pts) {
        this.games_played = games_played;
        this.player_id = player_id;
        this.min = min;
        this.reb = reb;
        this.ast = ast;
        this.stl = stl;
        this.blk = blk;
        this.pts = pts;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public double getReb() {
        return reb;
    }

    public void setReb(double reb) {
        this.reb = reb;
    }

    public double getAst() {
        return ast;
    }

    public void setAst(double ast) {
        this.ast = ast;
    }

    public double getStl() {
        return stl;
    }

    public void setStl(double stl) {
        this.stl = stl;
    }

    public double getBlk() {
        return blk;
    }

    public void setBlk(double blk) {
        this.blk = blk;
    }

    public double getPts() {
        return pts;
    }

    public void setPts(double pts) {
        this.pts = pts;
    }
}
