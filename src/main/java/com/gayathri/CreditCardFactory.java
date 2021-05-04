package com.gayathri;

public class CreditCardFactory {
    public CreditCard getCreditCard(String cardNumber) {
        if (cardNumber.length() == 16 && cardNumber.charAt(0) == '5' && cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5') {
            return new MasterCC();
        } else if (cardNumber.length() == 13 || cardNumber.length() == 16 && cardNumber.charAt(0) == '4') {
            return new VisaCC();
        } else if (cardNumber.length() == 15 && cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')) {
            return new AmExCC();
        } else if (cardNumber.length() == 16 && cardNumber.startsWith("6011")) {
            return new DiscoverCC();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}