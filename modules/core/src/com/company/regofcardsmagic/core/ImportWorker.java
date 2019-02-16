package com.company.regofcardsmagic.core;

import com.company.regofcardsmagic.entity.Card;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import groovy.util.MapEntry;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayGetAtMetaMethod;
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

import static org.apache.poi.ss.usermodel.CellType.*;

@Component("regOfCardsMagic_ImportWorker")
public class ImportWorker {
    FormulaEvaluator evaluator ;
    DataFormatter dataFormatter = new DataFormatter();
    Sheet sheet;

    //Отлажено
    public Integer searchForColumn (String nameOfColumn , int lineForSearch, int colMax) {
        for (int i = 0; i < colMax; i++) {
            String dataInColumn = dataFormatter.formatCellValue(sheet.getRow(lineForSearch).getCell(i));
            if(dataInColumn.equals(nameOfColumn)) {
                return i;
            }
        }
        throw new RuntimeException("Такой колонки не существует = " + nameOfColumn);
    }

    public HashMap<String,Integer> searchAllColumns (HashMap<String,String> paramsJuxtaposition , int lineForSearch, int colMax) {
        HashMap<String,Integer> result = new HashMap<>();
        for (Map.Entry paramJuxtAposition : paramsJuxtaposition.entrySet()) {
            result.put(paramJuxtAposition.getKey().toString(),searchForColumn(paramJuxtAposition.getValue().toString(),lineForSearch,colMax));
        }
        return result;
    }

    public String returnDataFromColumn (int line , int col) {
        Cell cell = sheet.getRow(line).getCell(col);
        CellValue cellValue = evaluator.evaluate(cell);

        switch (cellValue.getCellType()) {
            case BOOLEAN:
                return String.valueOf(cellValue.getBooleanValue());
            case NUMERIC:
                Integer value = (int) cellValue.getNumberValue();
                return String.valueOf(value);
            case STRING:
                return String.valueOf(cellValue.getStringValue());
            case BLANK:
                break;
            case ERROR:
                break;

            // CELL_TYPE_FORMULA will never happen
            case FORMULA:
                break;
        }
        return null;
    }

    public Card cardFactory (HashMap<String,String> parametersOfCard) {
        Card card = new Card();
        for (Map.Entry parameter : parametersOfCard.entrySet()) {
            if(!parameter.getKey().equals("amount")){
                card.setValue(String.valueOf(parameter.getKey()),String.valueOf(parameter.getValue()));
            }
        }
        return card;
    }

    public HashMap<String,String> returnParametersOfCard (HashMap<String,Integer> allcolumns,int line) {
        HashMap<String,String> paramsOfCard = new HashMap<>();
        for (Map.Entry column : allcolumns.entrySet()) {
            if(!column.getKey().equals("amount")) {
                paramsOfCard.put(column.getKey().toString(),returnDataFromColumn(line,(int)column.getValue()));
            }
        }
        return paramsOfCard;
    }

    public void importAllCardsFromExcel(File file, HashMap<String, String> params, int cellMaxNum,
                                        int rowWhereFindNum, int rowMaxNum, int numSheetInWorkBook, DataManager dataManager)
            throws FileNotFoundException, IOException {

        InputStream in = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(in);
        sheet = wb.getSheetAt(numSheetInWorkBook);
        evaluator = wb.getCreationHelper().createFormulaEvaluator();
        HashMap<String,Integer> allcolumns = searchAllColumns(params,rowWhereFindNum,cellMaxNum);

        for (int i = rowWhereFindNum + 1; i < rowMaxNum; i++) {
            HashMap<String,String> paramsOfCard = returnParametersOfCard(allcolumns,i);
            if(allcolumns.get("amount")!=null) {
                int amountOfCards = Integer.parseInt(returnDataFromColumn(i,allcolumns.get("amount")));
                for (int j = 0; j < amountOfCards; j++) {
                    dataManager.commit(cardFactory(paramsOfCard));
                }
            }

        }

        }
}
