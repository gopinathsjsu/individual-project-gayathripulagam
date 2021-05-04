package com.gayathri;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void test_readFromCsv() {
        CreditCard cc = new CreditCard();
        List<CreditCardRecord> records = cc.readFromCsv("input.csv");
        assertEquals("5410000000000000", records.get(0).getCardNumber());
        assertEquals("3/20/2030", records.get(0).getExpirationDate());
        assertEquals("Alice", records.get(0).getNameOfCardholder());
    }
}
