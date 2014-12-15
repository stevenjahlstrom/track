package com.horsey.service;

import com.horsey.model.Bet;
import com.horsey.model.Horse;

import java.util.HashMap;
import java.util.Map;

public class HorseServiceImpl implements HorseService {

    private static Map<Integer, Horse> horses = new HashMap<Integer, Horse>();
    static {
        horses.put(1, new Horse("That Darn Gray Cat", 5, Boolean.TRUE));
        horses.put(2, new Horse("Fort Utopia", 10, Boolean.FALSE));
        horses.put(3, new Horse("Count Sheep", 9, Boolean.FALSE));
        horses.put(4, new Horse("Ms Traitour", 4, Boolean.FALSE));
        horses.put(5, new Horse("Real Princess", 3, Boolean.FALSE));
        horses.put(6, new Horse("Pa Kettle", 5, Boolean.FALSE));
        horses.put(7, new Horse("Gin Stinger", 6, Boolean.FALSE));
    }

    private static Bet theBet = new Bet(0,0);

    @Override
    public Map<Integer, Horse> getHorses() {
        return horses;
    }

    public void displayHorses(Map<Integer, Horse> horses) {
        StringBuilder sb = new StringBuilder();
        sb.append("Horses:\n");

        for(Map.Entry<Integer, Horse> horse : horses.entrySet()) {
            sb.append(horse.getKey() + ", " + horse.getValue().getName() + ", " + horse.getValue().getOdds() + ", " + horse.getValue().isWon() + "\n");
        }
        System.out.println(sb.toString().trim());
    }

    public void setWinner(Integer key) {
        for(Map.Entry<Integer, Horse> horse : horses.entrySet()) {
            horse.getValue().setWon(Boolean.FALSE);
            if (horse.getKey() == key) {
                horse.getValue().setWon(Boolean.TRUE);
            }
        }
    }

    public Integer getWinner() {
        for(Map.Entry<Integer, Horse> horse : horses.entrySet()) {
            if (horse.getValue().isWon()) {
                return horse.getKey();
            }
        }
        return null; // this really should be a NoWinnerSetException
    }
    public void makeBet(Integer horse, Integer bet) {
        theBet.setHorse(horse);
        theBet.setBet(bet);
    }

    public Bet retrieveBet() {
        return theBet;
    }
}
