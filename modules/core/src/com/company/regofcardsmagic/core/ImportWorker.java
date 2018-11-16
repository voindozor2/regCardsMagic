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

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.inject.Inject;

@Component("regOfCardsMagic_ImportWorker")
public class ImportWorker {
    public List searchAllFromColumn(String key, Sheet sheet, int cellMaxNum, int rowWhereFindNum, int rowMaxNum) {
        List result = new ArrayList();
        for (int cellNum = 0; cellNum < cellMaxNum; cellNum++) {
            CellReference cellReference = new CellReference(rowWhereFindNum, cellNum);
            if (cellReference.toString().equals(key)) {
                for (int rowNum = 0; rowNum < rowMaxNum; rowNum++) {
                    CellReference cellReferenceCell = new CellReference(rowNum, cellNum);
                    result.add(cellReferenceCell.toString());
                }
            }
        }
        return result;
    }

    public String searchForOneColumnFromRow (String key , Sheet sheet , int cellMaxNum , int rowActual) {
        for (int cell = 0; cell < cellMaxNum; cell++) {
            CellReference cellReference = new CellReference(rowActual , cell);
            if (cellReference.toString().equals(key)) {
                return cellReference.toString();
            }
        }
        return null;
    }

    public HashMap<String , String> searchRow(Sheet sheet, int cellMaxNum, int rowActual , HashMap<String,String> params) {
        HashMap<String, String> result = new HashMap<>();

        for (Map.Entry<String,String> entry: params.entrySet()) {
            String column = searchForOneColumnFromRow(entry.getValue(),sheet,cellMaxNum,rowActual);
            if (column!= null) {
                result.put(entry.getKey(),column);
            }
        }
        
        return result;
    }
    public ArrayList<Card> importAllCardsFromExcel(File file, HashMap<String, String> params, int cellMaxNum,
                                                   int rowWhereFindNum, int rowMaxNum)
            throws FileNotFoundException, IOException {

        params.put("Name", "Наименование");
        params.put("Amount","Количество" );
        InputStream in = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(in);
        Sheet sheet = wb.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();

        for (int i = rowWhereFindNum + 1; i > rowMaxNum; i++) {
        }
        return null;
    }
}
