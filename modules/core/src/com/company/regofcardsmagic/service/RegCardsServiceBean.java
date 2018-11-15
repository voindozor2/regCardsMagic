package com.company.regofcardsmagic.service;

import com.haulmont.cuba.core.global.FileStorageException;
import org.springframework.stereotype.Service;

import com.haulmont.cuba.core.entity.FileDescriptor;
import java.io.IOException;

@Service(RegCardsService.NAME)
public class RegCardsServiceBean implements RegCardsService {

    public void importFromExcel (FileDescriptor fileDescriptor) throws IOException , FileStorageException {

    }
}