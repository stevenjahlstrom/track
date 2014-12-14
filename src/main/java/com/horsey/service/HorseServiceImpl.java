package com.horsey.service;

import com.horsey.model.Horse;

import java.util.HashMap;
import java.util.Map;

public class HorseServiceImpl implements HorseService {

    public Map<Integer, Horse> loadHorses() {

        Map<Integer, Horse> horses = new HashMap<Integer, Horse>();

        // static set of horses, no reason not to hardcode, they don't change
        horses.put(1, new Horse("That Darn Gray Cat", 5, Boolean.TRUE));
        horses.put(2, new Horse("Fort Utopia", 10, Boolean.FALSE));
        horses.put(3, new Horse("Count Sheep", 9, Boolean.FALSE));
        horses.put(4, new Horse("Ms Traitour", 4, Boolean.FALSE));
        horses.put(5, new Horse("Real Princess", 3, Boolean.FALSE));
        horses.put(6, new Horse("Pa Kettle", 5, Boolean.FALSE));
        horses.put(7, new Horse("Gin Stinger", 6, Boolean.FALSE));
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

    public void setWinner(Map<Integer, Horse> horses, Integer key) {

        for(Map.Entry<Integer, Horse> horse : horses.entrySet()) {
            horse.getValue().setWon(Boolean.FALSE);

            if (horse.getKey() == key) {
                horse.getValue().setWon(Boolean.TRUE);
            }
        }
    }
}
