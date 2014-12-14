package com.horsey.service;

import com.horsey.model.Horse;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HorseServiceTest {

    private static final Integer ORIGINAL_WINNER_KEY = 1;
    private static final Integer TEST_KEY = 5;

    private HorseService service = new HorseServiceImpl();

    @Test
    public void setWinner() {
        // check default state
        Map<Integer, Horse> horses = service.getHorses();
        assertTrue(horses.get(1).isWon());

        service.setWinner(TEST_KEY);
        assertFalse(horses.get(ORIGINAL_WINNER_KEY).isWon());
        assertTrue(horses.get(TEST_KEY).isWon());

    }
}
