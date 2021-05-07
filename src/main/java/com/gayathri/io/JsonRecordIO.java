package com.gayathri.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.gayathri.record.InputRecord;
import com.gayathri.record.OutputRecord;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonRecordIO extends RecordIO {

    @Override
    public List<InputRecord> read(String filename) {
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
        return getObjectMapper().readerFor(InputRecord.class);
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new JsonMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return mapper;
    }
}