package com.horsey.service;

import com.horsey.model.Currency;
import com.horsey.model.enums.Demonination;

public class DispenseServiceImpl implements DispenseService {

    DisplayService displayService = new DisplayServiceImpl();

    Currency currency = Currency.getCurrency();

    private static int balance;
    private static int payout;

    public String dispenseWinnings(Integer thePayout) {

        balance = currency.getTotalCashOnHand();
        payout = thePayout;

        // This should be a recursive function but this will work for now
        if (payout > balance) {
            displayService.displayAllMessages("Insufficient Funds: " + payout);
        }

        int hundred = makeChange(Demonination.HUNDRED.getValue());
        int twenty = makeChange(Demonination.TWENTY.getValue());
        int ten = makeChange(Demonination.TEN.getValue());
        int five = makeChange(Demonination.FIVE.getValue());
        int one = makeChange(Demonination.ONE.getValue());

        if(!adjustInventory(hundred, twenty, ten, five, one)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Dispensing:\n");
        sb.append("$1," + one + "\n");
        sb.append("$5," + five + "\n");
        sb.append("$10," + ten + "\n");
        sb.append("$20," + twenty + "\n");
        sb.append("$100," + hundred);
        return sb.toString();
    }

    private int makeChange(int currency) {
        int result = payout / currency;
        balance -= result * currency;
        payout -= result * currency;
        return result;
    }

    private boolean adjustInventory(int hundred, int twenty, int ten, int five, int one) {
        int oldHundred = currency.getHundred();
        int oldTwenty = currency.getTwenty();
        int oldTen = currency.getTen();
        int oldFive = currency.getFive();
        int oldOne = currency.getOne();

        boolean success = true;

        if (currency.getHundred() >= hundred) {
            currency.setHundred(currency.getHundred() - hundred);
        } else {
            success = false;
        }
        if (currency.getTwenty() >= twenty) {
            currency.setTwenty(currency.getTwenty() - twenty);
        } else {
            success = false;
        }
        if (currency.getTen() >= ten) {
            currency.setTen(currency.getTen() - ten);
        } else {
            success = false;
        }
        if (currency.getFive() >= five) {
            currency.setFive(currency.getFive() - five);
        } else {
            success = false;
        }
        if (currency.getOne() >= one) {
            currency.setOne(currency.getOne() - one);
        } else {
            success = false;
        }

        if (success == false) {
            currency.setHundred(oldHundred);
            currency.setTwenty(oldTwenty);
            currency.setTen(oldTen);
            currency.setFive(oldFive);
            currency.setOne(oldOne);
        }

        return success;
    }
}
