package com.company.regofcardsmagic.service;

import com.company.regofcardsmagic.core.ExportWorker;
import com.company.regofcardsmagic.core.ImportWorker;
import com.haulmont.cuba.core.global.FileStorageException;
import org.springframework.stereotype.Service;

import com.haulmont.cuba.core.entity.FileDescriptor;

import javax.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

@Service(RegCardsService.NAME)
public class RegCardsServiceBean implements RegCardsService {
    @Inject
    private ImportWorker importWorker;

    @Inject
    private ExportWorker exportWorker;

    public void importFromExcel (File file , HashMap<String, String> params, int cellMaxNum,
                                 int rowWhereFindNum, int rowMaxNum) throws FileNotFoundException,IOException {
    importWorker.importAllCardsFromExcel(file,params,cellMaxNum,rowWhereFindNum,rowMaxNum);
    }
}