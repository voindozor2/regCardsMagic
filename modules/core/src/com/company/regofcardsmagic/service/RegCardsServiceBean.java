package com.company.regofcardsmagic.service;

import com.company.regofcardsmagic.core.ExportWorker;
import com.company.regofcardsmagic.core.ImportWorker;
import com.haulmont.cuba.core.global.FileStorageException;
import org.springframework.stereotype.Service;

import com.haulmont.cuba.core.entity.FileDescriptor;

import javax.inject.Inject;
import java.io.IOException;

@Service(RegCardsService.NAME)
public class RegCardsServiceBean implements RegCardsService {
    @Inject
    private ImportWorker importWorker;

    @Inject
    private ExportWorker exportWorker;

    public void importFromExcel (FileDescriptor fileDescriptor) throws IOException , FileStorageException {
    importWorker.importAllCardsFromExcel(fileDescriptor);
    }
}