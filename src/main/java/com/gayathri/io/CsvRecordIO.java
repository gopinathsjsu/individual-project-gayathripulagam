package com.gayathri.io;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gayathri.CreditCard;
import com.gayathri.OutputRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvRecordIO implements RecordIO {

    @Override
    public List<CreditCard> read(String filename) {
        List<CreditCard> records = new ArrayList<>();
        File file = new File(filename);
        try (Reader reader = new FileReader(file)) {
            MappingIterator<CreditCard> mi = getCsvReader().readValues(reader);
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
        CsvSchema schema = CsvSchema.builder()
                .addColumn("CardNumber")
                .addColumn("CardType")
                .addColumn("ErrorMessage")
                .build()
                .withHeader();
        try {
            ObjectWriter writer = getCsvMapper().writer(schema);
            writer.writeValue(file, records);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private ObjectReader getCsvReader() {
        CsvMapper mapper = getCsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        return mapper.readerFor(CreditCard.class).with(schema);
    }

    private CsvMapper getCsvMapper() {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
        return csvMapper;
    }
}