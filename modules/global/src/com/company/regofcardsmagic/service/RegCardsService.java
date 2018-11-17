package com.company.regofcardsmagic.service;


import com.haulmont.cuba.core.global.FileStorageException;

import com.haulmont.cuba.core.entity.FileDescriptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public interface RegCardsService {
    String NAME = "regofcardsmagic_RegCardsService";

    void importFromExcel (File file , HashMap<String, String> params, int cellMaxNum,
                          int rowWhereFindNum, int rowMaxNum,int numSheetInWorkBook) throws FileNotFoundException,IOException;
}