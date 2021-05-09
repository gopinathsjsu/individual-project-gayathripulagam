package com.gayathri.io;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gayathri.CreditCard;
import com.gayathri.OutputRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class XmlRecordIO implements RecordIO {

    @Override
    public List<CreditCard> read(String filename) {
        List<CreditCard> records = new ArrayList<>();
        File file = new File(filename);
        try (Reader reader = new FileReader(file)) {
            MappingIterator<CreditCard> mi = getXmlReader().readValues(reader);
            while (mi.hasNext()) {
                CreditCard current = mi.next();
                records.add(current);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public boolean write(String filename, List<OutputRecord> records) {
        File file = new File(filename);
        try {
            getXmlMapper().writeValue(file, records);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private XmlMapper getXmlMapper() {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return mapper;
    }

    private ObjectReader getXmlReader() {
        return getXmlMapper().readerFor(CreditCard.class);
    }
}