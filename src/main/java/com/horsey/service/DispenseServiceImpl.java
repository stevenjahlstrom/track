package com.horsey.service;

import com.horsey.model.Currency;

public class DispenseServiceImpl implements DispenseService {

    DisplayService displayService = new DisplayServiceImpl() ;

    public String dispenseWinnings(Integer theBet) {

        int balance = Currency.getTotalCashOnHand();

        // This should be a recursive funtion but this will work for now
        if (theBet > balance) {
            displayService.displayAllMessages("Insufficient Funds: " + theBet);
        }

        return "";
    }
}
