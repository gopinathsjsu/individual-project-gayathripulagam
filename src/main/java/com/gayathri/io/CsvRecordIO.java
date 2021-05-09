package com.gayathri.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gayathri.CreditCard;
import com.gayathri.OutputRecord;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvRecordIO extends RecordIO {

    @Override
    public List<CreditCard> read(String filename) {
        return readHelper(getObjectReader(), filename);
    }

    @Override
    public boolean write(String filename, List<OutputRecord> records) {
        File file = new File(filename);
        CsvSchema schema = CsvSchema.builder()
                .addColumn("CardNumber")
                .addColumn("CardType")
                .addColumn("ErrorMessage")
                .build()
                .withHeader();
        try {
            ObjectWriter writer = getObjectMapper().writer(schema);
            writer.writeValue(file, records);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private ObjectReader getObjectReader() {
        ObjectMapper mapper = getObjectMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        return mapper.readerFor(CreditCard.class).with(schema);
    }

    private ObjectMapper getObjectMapper() {
        ObjectMapper csvMapper = new CsvMapper();
        csvMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return csvMapper;
    }
}