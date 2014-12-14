package com.horsey.service;

import com.horsey.model.Currency;

public class DisplayServiceImpl implements DisplayService {

    Currency currency = new Currency();
    HorseService horseService = new HorseServiceImpl();


    @Override
    public void displayInventory() {
        currency.displayCurrencyInventory();

    }

    @Override
    public void displayHorses() {
        horseService.displayHorses(horseService.loadHorses());

    }

    @Override
    public void displayInventoryAndHorses() {
        displayInventory();
        displayHorses();
    }


    // TODO - sja: Restore output
    @Override
    public void displayMessage(String msg) {
//        System.out.println(msg);
//        displayInventoryAndHorses();
    }

}
