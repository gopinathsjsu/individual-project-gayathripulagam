package com.gayathri;

import com.gayathri.io.RecordIO;
import com.gayathri.io.RecordIOFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Invalid syntax. Usage: java Main <input filename> <output filename>");
            System.exit(1);
        }

        String errorMessage = "Unsupported Card Type";
        String inputFilename = args[0];
        String outputFilename = args[1];
        Utils.validatePaths(inputFilename, outputFilename);
        RecordIO io = new RecordIOFactory().getRecordIO(inputFilename);
        List<CreditCard> creditCardList = io.read(inputFilename);
        List<OutputRecord> output = creditCardList
                .stream()
                .map(record -> {
                    String cardNumber = record.getCardNumber();
                    try {
                        return new OutputRecord(
                                cardNumber,
                                new CreditCardFactory().getCreditCard(cardNumber).toString(),
                                errorMessage);
                    } catch (UnsupportedOperationException e) {
                        return new OutputRecord(
                                cardNumber,
                                null,
                                errorMessage
                        );
                    }
                })
                .collect(Collectors.toList());
        boolean writeSuccess = io.write(outputFilename, output);
        if (writeSuccess) {
            System.out.println("Output successfully written to " + outputFilename);
        } else {
            System.out.println("Failed to write output");
        }
    }
}