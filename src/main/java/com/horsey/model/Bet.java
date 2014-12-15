package com.horsey.model;

public class Bet {

    private Integer horse;
    private Integer bet;

    public Bet(Integer horse, Integer bet) {
        this.horse = horse;
        this.bet = bet;
    }

    public Integer getHorse() {
        return horse;
    }

    public void setHorse(Integer horse) {
        this.horse = horse;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public String toString() {
        String str = ("Horse: " + horse + " Bet: " + bet);
        return str;
    }

}
