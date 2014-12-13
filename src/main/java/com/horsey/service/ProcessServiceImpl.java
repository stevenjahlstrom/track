package com.horsey.service;

import com.horsey.model.Currency;

public class ProcessServiceImpl implements ProcessService {

    HorseService horseService = new HorseServiceImpl();
    DisplayService displayService = new DisplayServiceImpl();
    Currency currency = new Currency();

    public void processInput(String input) {
        int inputLength = input.length();
        if (inputLength == 1) {
            processSingleCommands(input);
        }
        else if (validateText(input) &&  inputLength >= 2) {
            System.out.println("Invalid Command: " + input);
        }
        else if (!validateText(input)) {
            processBet(input);
        }
    }

    @Override
    public boolean processBet(String input) {
        return false;
    }

    private void processSingleCommands(String input) {
        String in = Character.toString(input.charAt(0));
        switch (in) {
            case "q": {
                System.exit(0);
                break;
            }
            case "r": {
                currency.reload();
                displayService.displayInventoryAndHorses();
                break;
            }
            default:
                System.out.println("Invalid Command: " + input);
        }
    }

    private boolean validateText(String input) {
        //return input.matches(".*\\d+.*");
        return input.matches("^[0-9]+$");
    }
}
