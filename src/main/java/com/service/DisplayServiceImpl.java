package com.service;

import com.model.Currency;

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
}
