package com.gayathri.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gayathri.CreditCardRecord;

import java.util.List;

public class CsvRecordIO extends RecordIO {

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
        ObjectMapper mapper = new CsvMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        return mapper.readerFor(CreditCardRecord.class).with(schema);
    }
}