package com.gayathri.io;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.gayathri.CreditCard;
import com.gayathri.CreditCardRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public abstract class RecordIO {
    abstract public List<CreditCardRecord> read(String filename);

    abstract public void write();

    protected List<CreditCardRecord> readHelper(ObjectReader objectReader, String filename) {
        List<CreditCardRecord> records = new ArrayList<>();
        ClassLoader classLoader = CreditCard.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try (Reader reader = new FileReader(file)) {
            MappingIterator<CreditCardRecord> mi = objectReader.readValues(reader);
            while (mi.hasNext()) {
                CreditCardRecord current = mi.next();
                records.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    abstract protected ObjectReader getObjectReader();
}