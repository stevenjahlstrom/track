package com.horsey.model;

import com.google.common.base.Objects;



public class Currency {

    private static int one;
    private  static int five;
    private static int ten;
    private  static int twenty;
    private static int hundred;

    public Currency(int one, int five, int ten, int twenty, int hundred) {
        this.one = one;
        this.five = five;
        this.ten = ten;
        this.twenty = twenty;
        this.hundred = hundred;
    }

    public static Currency currency = new Currency(10, 10, 10, 10, 10);
    public static Currency getCurrency() { return currency; }
    public static int getTotalCashOnHand() {
        return (one * 1) + (five * 5) + (ten * 10) +  (twenty * 20) + (hundred * 100);
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getFive() {
        return five;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getTwenty() {
        return twenty;
    }

    public void setTwenty(int twenty) {
        this.twenty = twenty;
    }

    public int getHundred() {
        return hundred;
    }

    public void setHundred(int hundred) {
        this.hundred = hundred;
    }

    public void reload() {
        one = five = ten = twenty = hundred = 10;
    }

    public void displayCurrencyInventory() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory:\n");
        sb.append("$1," + getOne() + "\n");
        sb.append("$5," + getFive() + "\n");
        sb.append("$10 " + getTen() + "\n");
        sb.append("$20," + getTwenty() + "\n");
        sb.append("$100," + getHundred() + "\n");
        System.out.println(sb.toString().trim());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(one, five, ten, twenty, hundred);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Currency other = (Currency) obj;
        return Objects.equal(this.one, other.one) && Objects.equal(this.five, other.five) && Objects.equal(this.ten, other.ten) && Objects.equal(this.twenty, other.twenty) && Objects.equal(this.hundred, other.hundred);
    }
}
