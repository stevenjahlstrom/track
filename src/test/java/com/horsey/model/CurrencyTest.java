package com.horsey.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyTest {

    Currency currency = new Currency();

   @Test
    public void testTotalCashOnHand () {
       System.out.println(currency.getTotalCashOnHand());
       assertEquals("$1360", currency.getTotalCashOnHand());
    }

    @Test
    public void testReload() {
        currency.setFive(0);
        currency.setTen(2);
        assertEquals("$1230", currency.getTotalCashOnHand());
        currency.reload();
        assertEquals("$1360", currency.getTotalCashOnHand());
    }
}
