package com.model;

import com.google.common.base.Objects;

public class Horse {

    private String name;
    private int odds;
    private boolean won;

    public Horse(String name, int odds, boolean won) {
        this.name = name;
        this.odds = odds;
        this.won = won;
    }

    public Horse(){};

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

    @Override
    public int hashCode() {
        return Objects.hashCode(name, odds);
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Horse other = (Horse) obj;
        return Objects.equal(this.name, other.name) && Objects.equal(this.odds, other.odds);
    }
}
