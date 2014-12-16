package com.horsey.service;

import com.horsey.model.Currency;

public class DisplayServiceImpl implements DisplayService {

    Currency currency = Currency.getCurrency();
    HorseService horseService = new HorseServiceImpl();


    @Override
    public void displayInventory() {
        currency.displayCurrencyInventory();
    }

    @Override
    public void displayHorses() {
        horseService.displayHorses(horseService.getHorses());

    }

    @Override
    public void displayInventoryAndHorses() {
        displayInventory();
        displayHorses();
    }

    @Override
    public void displayAllMessages(String msg) {
        System.out.println(msg);
        displayInventoryAndHorses();
    }

    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

}
