package com.horsey.service;

import com.horsey.model.Currency;
import com.horsey.model.enums.Demonination;

public class DispenseServiceImpl implements DispenseService {

    DisplayService displayService = new DisplayServiceImpl();

    private static int balance;
    private static int bet;

    public String dispenseWinnings(Integer theBet) {

        int balance = Currency.getTotalCashOnHand();
        int bet = theBet;

        // This should be a recursive function but this will work for now
        if (theBet > balance) {
            displayService.displayAllMessages("Insufficient Funds: " + theBet);
        }

        int one_hundred = makeChange(Demonination.HUNDRED.getValue());
        int twenty = makeChange(Demonination.TWENTY.getValue());
        int ten = makeChange(Demonination.TEN.getValue());
        int five = makeChange(Demonination.FIVE.getValue());
        int one = makeChange(Demonination.ONE.getValue());

        return "";
    }

    private int makeChange(int currency) {

        int result = bet / currency;
        balance -= result * currency;
        bet -= result * currency;
        return result;
    }
}
