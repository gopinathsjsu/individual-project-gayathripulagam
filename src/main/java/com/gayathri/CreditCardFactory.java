package com.gayathri;

public class CreditCardFactory {
    public CreditCard getCreditCard(String cardNumber) {
        if (MasterCC.isValid(cardNumber)) {
            return new MasterCC();
        } else if (VisaCC.isValid(cardNumber)) {
            return new VisaCC();
        } else if (AmExCC.isValid(cardNumber)) {
            return new AmExCC();
        } else if (DiscoverCC.isValid(cardNumber)) {
            return new DiscoverCC();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}