package com.company.regofcardsmagic.core;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.inject.Inject;

@Component("regOfCardsMagic_ImportWorker")
public class ImportWorker {


    public void importAllCardsFromExcel (FileDescriptor fileDescriptor) throws IOException,FileStorageException {
        FileLoader fileLoader= AppBeans.get(FileLoader.class);
        InputStream in = fileLoader.openStream(fileDescriptor);
        HSSFWorkbook wb = new HSSFWorkbook(in);
        Sheet sheet = wb.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();


    }
}
