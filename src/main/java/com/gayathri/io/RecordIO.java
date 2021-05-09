package com.gayathri.io;

import com.gayathri.cc.CreditCard;

import java.util.List;

public interface RecordIO {
    List<CreditCard> read(String filename);

    boolean write(String filename, List<CreditCard> records);
}