package com.gayathri.io;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.gayathri.CreditCard;
import com.gayathri.OutputRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public abstract class RecordIO {
    abstract public List<CreditCard> read(String filename);

    abstract public boolean write(String filename, List<OutputRecord> records);

    protected List<CreditCard> readHelper(ObjectReader objectReader, String filename) {
        List<CreditCard> records = new ArrayList<>();
        ClassLoader classLoader = CreditCard.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try (Reader reader = new FileReader(file)) {
            MappingIterator<CreditCard> mi = objectReader.readValues(reader);
            while (mi.hasNext()) {
                CreditCard current = mi.next();
                records.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}