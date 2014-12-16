package com.horsey.model;

public class Horse {

    private String name;
    private int odds;
    private Boolean won;

    public Horse(String name, int odds, Boolean won) {
        this.name = name;
        this.odds = odds;
        this.won = won;
    }

    public Horse() {
    }

    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public Boolean isWon() {
        return won;
    }

    public void setWon(Boolean won) {
        this.won = won;
    }

    // At this point there is really no reason to override equals and hashcode -- if I did I'd use guava to do so
}
