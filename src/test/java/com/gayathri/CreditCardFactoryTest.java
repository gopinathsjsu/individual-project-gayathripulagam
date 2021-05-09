package com.gayathri;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardFactoryTest {

    @Test
    public void test_CreditCardFactory_DiscoverCard() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("6011123456789123");
        assertTrue(cc instanceof DiscoverCC);
        assertEquals("Discover", cc.toString());
    }

    @Test
    public void test_CreditCardFactory_VisaCC() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("4120000000000");
        assertTrue(cc instanceof VisaCC);
        assertEquals("Visa", cc.toString());
    }

    @Test
    public void test_CreditCardFactory_AmexCC() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("341000000000000");
        assertTrue(cc instanceof AmExCC);
        assertEquals("AmericanExpress", cc.toString());
    }

    @Test
    public void test_CreditCardFactory_MasterCC() {
        CreditCardFactory factory = new CreditCardFactory();
        CreditCard cc = factory.getCreditCard("5410000000000000");
        assertTrue(cc instanceof MasterCC);
        assertEquals("MasterCard", cc.toString());

    }

    @Test
    public void test_CreditCardFactory_invalidCreditCardNumber() {
        CreditCardFactory factory = new CreditCardFactory();
        assertThrows(UnsupportedOperationException.class, () -> factory.getCreditCard("000"));
    }

}
