package com.gayathri.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.gayathri.CreditCard;
import com.gayathri.OutputRecord;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonRecordIO extends RecordIO {

    @Override
    public List<CreditCard> read(String filename) {
        ObjectReader reader = getObjectReader();
        return readHelper(reader, filename);
    }

    @Override
    public boolean write(String filename, List<OutputRecord> records) {
        File file = new File(filename);
        try {
            getObjectMapper().writeValue(file, records);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private ObjectReader getObjectReader() {
        return getObjectMapper().readerFor(CreditCard.class);
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new JsonMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }
}