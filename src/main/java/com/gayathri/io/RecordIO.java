package com.gayathri.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.gayathri.CreditCard;
import com.gayathri.record.InputRecord;
import com.gayathri.record.OutputRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public abstract class RecordIO {
    abstract public List<InputRecord> read(String filename);

    abstract public boolean write(String filename, List<OutputRecord> records);

    protected List<InputRecord> readHelper(ObjectReader objectReader, String filename) {
        List<InputRecord> records = new ArrayList<>();
        ClassLoader classLoader = CreditCard.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try (Reader reader = new FileReader(file)) {
            MappingIterator<InputRecord> mi = objectReader.readValues(reader);
            while (mi.hasNext()) {
                InputRecord current = mi.next();
                records.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}