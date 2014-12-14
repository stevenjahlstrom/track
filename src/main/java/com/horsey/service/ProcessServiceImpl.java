package com.horsey.service;

import com.horsey.model.Currency;

public class ProcessServiceImpl implements ProcessService {

    HorseService horseService = new HorseServiceImpl();
    DisplayService displayService = new DisplayServiceImpl();
    Currency currency = new Currency();

    public void processInput(String input) {
        int inputLength = input.length();

        if (inputLength == 0) {
            displayService.displayMessage("Invalid Command: ");
            return;
        }
        // single char and not a number
        if (inputLength == 1 && !isNumeric(input)) {
            processSingleCommands(input);
            return;
        }
        // single char and a number
        if (inputLength == 1 && isNumeric(input)) {
           displayService.displayMessage("Invalid Command: " + input);
            return;
        }
        // if there is a number in the input
        if (isNumeric(input) && inputLength >= 2) {
            processMultiCommands(input);
        }
        if (!isNumeric(input)) {
            processBet(input);
        }
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
                displayService.displayMessage("Invalid Command: " + input);
        }
    }

    private void processMultiCommands(String input) {
        String in = Character.toString(input.charAt(0));
        if (isNumeric(in)) {
            displayService.displayMessage("Hey, it starts with a number");
        }
        else {
            // it doesn't start with a number
            if (in.equalsIgnoreCase("w") && numberRange(input.substring(1).trim())) {

            }
            else {
                displayService.displayMessage("Invalid Command: " + input);
            }
        }
    }

    public boolean processBet(String input) { return false; }

    private boolean isNumeric(String input) {
        return input.matches(".*\\d+.*");
    }

    private boolean numberRange(String input) {
        int number = Integer.parseInt(input);
        return number >= 1 && number <=7 ? true : false;
    }
}
