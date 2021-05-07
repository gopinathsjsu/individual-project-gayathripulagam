package com.gayathri.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.gayathri.CreditCardRecord;

import java.util.List;

public class JsonRecordIO extends RecordIO {

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
        ObjectMapper mapper = new JsonMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return mapper.readerFor(CreditCardRecord.class);
    }
}