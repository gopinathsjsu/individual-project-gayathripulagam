package com.gayathri;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CreditCardTest {

    @Test
    public void test_readFromCsv() {
        CreditCard cc = new CreditCard();
        List<CreditCardRecord> records = cc.readFromCsv("input.csv");
        CreditCardRecord firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_CreditCardFactory_DiscoverCard() {
        CreditCardFactory factory = new CreditCardFactory();
        assertTrue(factory.getCreditCard("6011123456789123") instanceof DiscoverCC);
    }

    @Test
    public void test_CreditCardFactory_VisaCC(){
        CreditCardFactory factory = new CreditCardFactory();
        assertTrue(factory.getCreditCard( "4120000000000") instanceof  VisaCC);
    }

    @Test
    public void test_CreditCardFactory_AmexCC(){
        CreditCardFactory factory = new CreditCardFactory();
        assertTrue(factory.getCreditCard( "341000000000000") instanceof  AmExCC);
    }

    @Test
    public void test_CreditCardFactory_MasterCC(){
        CreditCardFactory factory = new CreditCardFactory();
        assertTrue(factory.getCreditCard( "5410000000000000") instanceof  MasterCC);
    }

    @Test
    public void test_CreditCardFactory_invalidCreditCardNumber() {
        CreditCardFactory factory = new CreditCardFactory();
        assertThrows(UnsupportedOperationException.class, () -> factory.getCreditCard("000"));
    }

}
