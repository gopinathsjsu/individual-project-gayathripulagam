package com.gayathri.io;

import com.gayathri.CreditCard;
import com.gayathri.OutputRecord;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordIOTest {

    @Test
    public void test_readFromCsv() {
        String filename = "src/main/resources/input.csv";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_readFromXml() {
        String filename = "src/main/resources/input.xml";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_readFromJson() {
        String filename = "src/main/resources/input.json";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }
}
