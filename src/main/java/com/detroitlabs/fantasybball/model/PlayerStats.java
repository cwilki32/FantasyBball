package com.detroitlabs.fantasybball.model;

public class PlayerStats {



    private int id;
    private int ast; //assists
    private int blk; //blocks
    private int dreb; //defensive rebounds
    private int fg3_pct; //3 pt field goal percentage fg3m/fg3a
    private int fg3a; //3 pt fg attempted
    private int fg3m; //3 pt made
    private int fg_pct; //field goal percentage
    private int fga; //field goals attempted
    private int fgm; //field goals made
    private int ft_pct; //free throw percentage
    private int fta; //free throw attempted
    private int ftm; //free throw made
    private Player player; //field that maps to the JSON player info
    private int pts;
    private int reb;
    private int stl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDreb() {
        return dreb;
    }

    public void setDreb(int dreb) {
        this.dreb = dreb;
    }

    public int getFg3_pct() {
        return fg3_pct;
    }

    public void setFg3_pct(int fg3_pct) {
        this.fg3_pct = fg3_pct;
    }

    public int getFg3a() {
        return fg3a;
    }

    public void setFg3a(int fg3a) {
        this.fg3a = fg3a;
    }

    public int getFg3m() {
        return fg3m;
    }

    public void setFg3m(int fg3m) {
        this.fg3m = fg3m;
    }

    public int getFg_pct() {
        return fg_pct;
    }

    public void setFg_pct(int fg_pct) {
        this.fg_pct = fg_pct;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public int getFgm() {
        return fgm;
    }

    public void setFgm(int fgm) {
        this.fgm = fgm;
    }

    public int getFt_pct() {
        return ft_pct;
    }

    public void setFt_pct(int ft_pct) {
        this.ft_pct = ft_pct;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public int getFtm() {
        return ftm;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public int getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }
}
