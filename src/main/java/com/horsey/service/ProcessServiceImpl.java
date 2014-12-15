package com.horsey.service;

import com.horsey.model.Currency;
import com.horsey.model.Horse;
import org.apache.commons.lang3.StringUtils;

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
        // single char
        if (inputLength == 1) {
            processSingleCommands(input);
            return;
        }
        // multi char = is there is a number in the input?
        if (isNumeric(input) && inputLength >= 2) {
            processMultiCommands(input);
        } else {
            displayService.displayMessage("Invalid Command: " + input);
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
            if (processBet(in, input)) {
                Integer winnerKey = horseService.getWinner();
                Integer betNumber = Integer.parseInt(in);
                Horse winner = (Horse) horseService.getHorses().get(winnerKey);
                if (winnerKey == betNumber) {
                    displayService.displayMessage("Payout: " + winner.getName() + ", $" + winner.getOdds() * horseService.retrieveBet().getBet());
                }
                else {
                    // if loser
                    Horse loser = (Horse) horseService.getHorses().get(betNumber);
                    displayService.displayMessage("No Payout: " + loser.getName());
                }
            } else {
                displayService.displayMessage("Invalid Bet: " + input);
            }
        } else {
            // it doesn't start with a number
            if (in.equalsIgnoreCase("w") && numberRange(input.substring(1).trim())) {
                horseService.setWinner(Integer.parseInt(input.substring(1).trim()));
                displayService.displayInventoryAndHorses();
            } else {
                displayService.displayMessage("Invalid Command: " + input);
            }
        }
    }

    public boolean processBet(String horse, String input) {

        if (!numberRange(horse)) {
            displayService.displayMessage("Invalid Horse Number: " + horse);
            return false;
        }
        String bet = input.substring(1).trim();

        if (StringUtils.isNumeric((bet))) {
            horseService.makeBet(Integer.parseInt(horse), Integer.parseInt(bet));
            return true;
        }
        return false;
    }

    private boolean isNumeric(String input) {
        return input.matches(".*\\d+.*");
    }

    private boolean numberRange(String input) {
        int number = Integer.parseInt(input);
        return number >= 1 && number <= 7 ? true : false;
    }
}
