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
        String filename = "input.csv";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_readFromXml() {
        String filename = "input.xml";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_readFromJson() {
        String filename = "input.json";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<CreditCard> records = recordIO.read(filename);
        CreditCard firstRecord = records.get(0);
        assertEquals("5410000000000000", firstRecord.getCardNumber());
        assertEquals("3/20/2030", firstRecord.getExpirationDate());
        assertEquals("Alice", firstRecord.getNameOfCardholder());
    }

    @Test
    public void test_writeXML() {
        String filename = "output.xml";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<OutputRecord> records = new ArrayList<>();
        records.add(new OutputRecord("123", "MasterCard", null));
        records.add(new OutputRecord("456", "Discover", null));
        recordIO.write(filename, records);
    }

    @Test
    public void test_writeJSON() {
        String filename = "output.json";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<OutputRecord> records = new ArrayList<>();
        records.add(new OutputRecord("123", "MasterCard", null));
        records.add(new OutputRecord("456", "Discover", null));
        recordIO.write(filename, records);
    }

    @Test
    public void test_writeCSV() {
        String filename = "output.csv";
        RecordIO recordIO = new RecordIOFactory().getRecordIO(filename);
        List<OutputRecord> records = new ArrayList<>();
        records.add(new OutputRecord("123", "MasterCard", null));
        records.add(new OutputRecord("456", "Discover", null));
        recordIO.write(filename, records);
    }
}
