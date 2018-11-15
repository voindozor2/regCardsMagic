package com.company.regofcardsmagic.service;


import com.haulmont.cuba.core.global.FileStorageException;

import com.haulmont.cuba.core.entity.FileDescriptor;
import java.io.IOException;

public interface RegCardsService {
    String NAME = "regofcardsmagic_RegCardsService";

    void importFromExcel (FileDescriptor fileDescriptor) throws IOException, FileStorageException;
}