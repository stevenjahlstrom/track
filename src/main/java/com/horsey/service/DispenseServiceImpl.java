package com.horsey.service;

import com.horsey.model.Currency;

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

        int one_hundred = makeChange(100);
        int twenty = makeChange(20);
        int ten = makeChange(10);
        int five = makeChange(5);
        int one = makeChange(1);

        return "";
    }

    private int makeChange(int currency) {

        int result = bet / currency;
        balance -= result * currency;
        bet -= result * currency;
        return result;
    }
}
