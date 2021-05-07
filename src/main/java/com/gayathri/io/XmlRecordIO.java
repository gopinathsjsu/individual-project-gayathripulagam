package com.gayathri.io;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gayathri.record.InputRecord;
import com.gayathri.record.OutputRecord;

import java.io.*;
import java.util.List;

public class XmlRecordIO extends RecordIO {

    @Override
    public List<InputRecord> read(String filename) {
        return readHelper(getObjectReader(), filename);
    }

    @Override
    public boolean write(String filename, List<OutputRecord> records) {
        File file = new File(filename);
        ObjectMapper xmlMapper = getObjectMapper();
        try {
            xmlMapper.writeValue(file, records);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return mapper;
    }

    private ObjectReader getObjectReader() {
        return getObjectMapper().readerFor(InputRecord.class);
    }
}