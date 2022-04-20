package com.detroitlabs.fantasybball.model;

public class SeasonAvgStats {
    //not all will be used but here if needed; see PlayerStats for definitions of acronyms
    //used to fetch data

    private int games_played;
    private int player_id;
    private int season;
    private String min;
    private double fgm;
    private double fga;
    private double fg3m;
    private double fg3a;
    private double ftm;
    private double fta;
    private double oreb;
    private double dreb;
    private double reb;
    private double ast;
    private double stl;
    private double blk;
    private double turnover;
    private double pf;
    private double pts;
    private double fg_pct;
    private double fg3_pct;
    private double ft_pct;


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

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public double getFgm() {
        return fgm;
    }

    public void setFgm(double fgm) {
        this.fgm = fgm;
    }

    public double getFga() {
        return fga;
    }

    public void setFga(double fga) {
        this.fga = fga;
    }

    public double getFg3m() {
        return fg3m;
    }

    public void setFg3m(double fg3m) {
        this.fg3m = fg3m;
    }

    public double getFg3a() {
        return fg3a;
    }

    public void setFg3a(double fg3a) {
        this.fg3a = fg3a;
    }

    public double getFtm() {
        return ftm;
    }

    public void setFtm(double ftm) {
        this.ftm = ftm;
    }

    public double getFta() {
        return fta;
    }

    public void setFta(double fta) {
        this.fta = fta;
    }

    public double getOreb() {
        return oreb;
    }

    public void setOreb(double oreb) {
        this.oreb = oreb;
    }

    public double getDreb() {
        return dreb;
    }

    public void setDreb(double dreb) {
        this.dreb = dreb;
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

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }

    public double getPts() {
        return pts;
    }

    public void setPts(double pts) {
        this.pts = pts;
    }

    public double getFg_pct() {
        return fg_pct;
    }

    public void setFg_pct(double fg_pct) {
        this.fg_pct = fg_pct;
    }

    public double getFg3_pct() {
        return fg3_pct;
    }

    public void setFg3_pct(double fg3_pct) {
        this.fg3_pct = fg3_pct;
    }

    public double getFt_pct() {
        return ft_pct;
    }

    public void setFt_pct(double ft_pct) {
        this.ft_pct = ft_pct;
    }


}
