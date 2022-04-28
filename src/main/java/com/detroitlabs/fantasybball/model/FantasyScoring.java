package com.detroitlabs.fantasybball.model;

//class used to hold methods to calculate fantasy scoring
public class FantasyScoring {

    /*
    Points: 1 point each
    Rebounds: 1.2 points each
    Assists: 1.5 points each
    Blocked Shots: 2 points each
    Steals: 2 points each
     */


    public FantasyScoring() {

    }

    public double calcScoreGame(int pts, int reb, int ast, int blk, int stl) {
        double fantasyScore = (pts*1) + (reb*1.2) + (ast*1.5) + (blk*2) + (stl*2);
        return fantasyScore;
    }

    public double calcScoreAvg(double pts, double reb, double ast, double blk, double stl) {
        double fantasyScore = (pts*1) + (reb*1.2) + (ast*1.5) + (blk*2) + (stl*2);
        return fantasyScore;
    }
}
