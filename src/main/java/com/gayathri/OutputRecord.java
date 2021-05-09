package com.gayathri.record;

public class OutputRecord {

    private String cardNumber;
    private String cardType;
    private String errorMessage;

    public OutputRecord(String cardNumber, String cardType, String errorMessage) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.errorMessage = errorMessage;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}