package com.detroitlabs.fantasybball.model;

public class DailyStatsObject implements Comparable<DailyStatsObject>{

    private String name;
    private int id;
    private int pts;
    private int reb;
    private int ast;
    private int blk;
    private int stl;
    private String teamName;
    private String pos;
    private double fantasyScore;

    public DailyStatsObject(String name, int id, int pts, int reb, int ast, int blk, int stl, String teamName, String pos) {
        this.name = name;
        this.id = id;
        this.pts = pts;
        this.reb = reb;
        this.ast = ast;
        this.blk = blk;
        this.stl = stl;
        this.teamName = teamName;
        this.pos = pos;
    }


    public double getFantasyScore() {
        return fantasyScore;
    }

    public void setFantasyScore(double fantasyScore) {
        this.fantasyScore = fantasyScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getBlk() {
        return blk;
    }

    public void setBlk(int blk) {
        this.blk = blk;
    }

    public int getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public int compareTo(DailyStatsObject comparestu) {
        int comparePts = ((DailyStatsObject)comparestu).getPts();
        return comparePts-this.pts;
    }

}