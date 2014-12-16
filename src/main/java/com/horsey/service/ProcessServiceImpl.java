package com.horsey.service;

import com.horsey.model.Currency;
import com.horsey.model.Horse;
import org.apache.commons.lang3.StringUtils;

public class ProcessServiceImpl implements ProcessService {

    HorseService horseService = new HorseServiceImpl();
    DisplayService displayService = new DisplayServiceImpl();
    DispenseService dispenseService = new DispenseServiceImpl();
    Currency currency = Currency.getCurrency();

    public void processInput(String input) {
        int inputLength = input.length();

        if (inputLength == 0) {
            displayService.displayAllMessages("Invalid Command: ");
            return;
        }
        // single char
        if (inputLength == 1) {
            processSingleCommands(input);
            return;
        }
        // multi char = is there is a number in the input?
        if (containsANumber(input) && inputLength >= 2) {
            processMultiCommands(input);
        } else {
            displayService.displayAllMessages("Invalid Command: " + input);
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
                displayService.displayAllMessages("Invalid Command: " + input);
        }
    }

    private void processMultiCommands(String input) {
        String in = Character.toString(input.charAt(0));
        if (StringUtils.isNumeric(in)) {
            if (processBet( Integer.parseInt(in), input)) {
                Integer winnerKey = horseService.getWinner();
                Integer betNumber = Integer.parseInt(in);
                Horse winner = (Horse) horseService.getHorses().get(winnerKey);
                if (winnerKey == betNumber) {

                    displayService.displayInventoryAndHorses();
                    Integer theBet = horseService.retrieveBet().getBet();
                    Integer theOdds = winner.getOdds();

                    StringBuilder sb = new StringBuilder("Payout: " + winner.getName() + ", $" + theOdds * theBet);

                    String result = dispenseService.dispenseWinnings(theBet * theOdds);

                    if (!result.isEmpty()) {
                        displayService.displayMessage(sb.toString());
                        displayService.displayMessage(result);
                    }
                }
                else {
                    // if loser
                    Horse loser = (Horse) horseService.getHorses().get(betNumber);
                    displayService.displayAllMessages("No Payout: " + loser.getName());
                }
            } else {
                displayService.displayAllMessages("Invalid Bet: " + input);
            }
        } else {
            // it doesn't start with a number
            Integer horseNumber = Integer.parseInt(input.substring(1).trim());
            if (in.equalsIgnoreCase("w") && numberRange(horseNumber)) {
                horseService.setWinner(Integer.parseInt(input.substring(1).trim()));
                displayService.displayInventoryAndHorses();
            } else {
                displayService.displayAllMessages("Invalid Command: " + input);
            }
        }
    }

    public boolean processBet(Integer horseNumber, String input) {

        if (!numberRange(horseNumber)) {
            displayService.displayAllMessages("Invalid Horse Number: " + horseNumber);
            return false;
        }
        String bet = input.substring(1).trim();

        if (StringUtils.isNumeric((bet))) {
            horseService.makeBet(horseNumber, Integer.parseInt(bet));
            return true;
        }
        return false;
    }

    private boolean containsANumber(String input) {
        return input.matches(".*\\d+.*");
    }

    private boolean numberRange(Integer horseNumber) {;
        return horseNumber >= 1 && horseNumber <= 7 ? true : false;
    }
}
