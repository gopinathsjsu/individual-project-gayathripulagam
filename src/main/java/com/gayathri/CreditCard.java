package com.gayathri;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CreditCard {

    public List<CreditCardRecord> readFromCsv(String filename) {
        List<CreditCardRecord> records = new ArrayList<>();
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        ObjectReader oReader = csvMapper.reader(CreditCardRecord.class).with(schema);
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

    public List<CreditCardRecord> readFromXml(String filename) {
        List<CreditCardRecord> records = new ArrayList<>();
        ObjectMapper mapper = new XmlMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        ObjectReader oReader = mapper.reader(CreditCardRecord.class);
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

    public List<CreditCardRecord> readFromJson(String filename) {
        List<CreditCardRecord> records = new ArrayList<>();
        ObjectMapper mapper = new JsonMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        ObjectReader oReader = mapper.reader(CreditCardRecord.class);
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
