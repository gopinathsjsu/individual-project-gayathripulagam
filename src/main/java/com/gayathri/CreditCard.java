package com.gayathri;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CreditCard {

    public List<CreditCardRecord> readFromCsv(String filename) {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        ObjectReader oReader = csvMapper.reader(CreditCardRecord.class).with(schema);
        List<CreditCardRecord> records = new ArrayList<>();
        ClassLoader classLoader = CreditCard.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try (Reader reader = new FileReader(file)) {
            MappingIterator<CreditCardRecord> mi = oReader.readValues(reader);
            while (mi.hasNext()) {
                CreditCardRecord current = mi.next();
                records.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
