package com.gayathri.io;

import com.gayathri.CreditCardRecord;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordIOTest {

    @Test
    public void test_readFromCsv() {
        String filename = "input.csv";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCardRecord> records = recordIO.read(filename);
        CreditCardRecord firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_readFromXml() {
        String filename = "input.xml";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCardRecord> records = recordIO.read(filename);
        CreditCardRecord firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_readFromJson() {
        String filename = "input.json";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCardRecord> records = recordIO.read(filename);
        CreditCardRecord firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

}
