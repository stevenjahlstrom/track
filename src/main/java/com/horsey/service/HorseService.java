package com.horsey.service;

import com.horsey.model.Horse;

import java.util.Map;

public interface HorseService {
    public Map loadHorses();
    public void displayHorses(Map<Integer, Horse> horses);
    public void setWinner(Integer key);
}
