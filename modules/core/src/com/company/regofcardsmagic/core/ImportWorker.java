package com.company.regofcardsmagic.core;

import com.company.regofcardsmagic.entity.Card;
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
import org.apache.poi.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import javax.inject.Inject;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
@Component("regOfCardsMagic_ImportWorker")
public class ImportWorker {


    public ArrayList<Card> importAllCardsFromExcel(File file, HashMap<String, String> params, int cellMaxNum,
                                                   int rowWhereFindNum, int rowMaxNum,int numSheetInWorkBook)
            throws FileNotFoundException, IOException {

        params.put("Name", "Наименование");
        params.put("Amount","Количество" );
        InputStream in = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(in);
        Sheet sheet = wb.getSheetAt(numSheetInWorkBook);
        DataFormatter dataFormatter = new DataFormatter();
        System.out.println("Now");
        return null;
    }
}
