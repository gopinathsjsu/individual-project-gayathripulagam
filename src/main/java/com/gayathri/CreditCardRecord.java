package com.gayathri;

public class CreditCardRecord {
    private String cardNumber;
    private String expirationDate;
    private String nameOfCardholder;

    public String getCardNumber() {
        return cardNumber.trim();
    }

    public String getExpirationDate() {
        return expirationDate.trim();
    }

    public String getNameOfCardholder() {
        return nameOfCardholder.trim();
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setNameOfCardholder(String nameOfCardholder) {
        this.nameOfCardholder = nameOfCardholder;
    }
}