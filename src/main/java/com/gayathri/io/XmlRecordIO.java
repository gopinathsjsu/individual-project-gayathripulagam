package com.gayathri.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gayathri.CreditCardRecord;

import java.util.List;

public class XmlRecordIO extends RecordIO {

    @Override
    public List<CreditCardRecord> read(String filename) {
        ObjectReader reader = getObjectReader();
        return readHelper(reader, filename);
    }

    @Override
    public void write() {

    }

    @Override
    protected ObjectReader getObjectReader() {
        ObjectMapper mapper = new XmlMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return mapper.readerFor(CreditCardRecord.class);
    }
}