package com.horsey.service;

import com.horsey.model.Horse;

import java.util.HashMap;
import java.util.Map;

public class HorseServiceImpl implements HorseService {

    public Map<Integer, Horse> loadHorses() {

        Map<Integer, Horse> horses = new HashMap<Integer, Horse>();

        // static set of horses, no reason not to hardcode them
        horses.put(1, new Horse("That Darn Gray Cat", 5, true));
        horses.put(2, new Horse("Fort Utopia", 10, false));
        horses.put(3, new Horse("Count Sheep", 9, false));
        horses.put(4, new Horse("Ms Traitour", 4, false));
        horses.put(5, new Horse("Real Princess", 3, false));
        horses.put(6, new Horse("Pa Kettle", 5, false));
        horses.put(7, new Horse("Gin Stinger", 6, false));

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


    // TODO - sja: write a test for this
    public void setWinner(Integer key) {
        Map<Integer, Horse> horses = loadHorses();

        for(Map.Entry<Integer, Horse> horse : horses.entrySet()) {
            horse.getValue().setWon(false);
            if (horse.getKey() == key) {
                horse.getValue().setWon(true);
            }
        }
    }
}
