package com.gayathri.io;

import com.gayathri.CreditCard;

import java.util.List;

public interface RecordIO {
    List<CreditCard> read(String filename);

    boolean write(String filename, List<CreditCard> records);
}