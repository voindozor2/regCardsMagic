package com.company.regofcardsmagic.core;

import com.company.regofcardsmagic.entity.Card;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import groovy.util.MapEntry;
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
    DataFormatter dataFormatter = new DataFormatter();
    //Отлажено
    public ArrayList<String> returnDataFormColumn (int col , int linesMax,Sheet sheet , int rowWhereFindNum) {
        ArrayList<String> column = new ArrayList<>();
        for (int i = rowWhereFindNum+1; i < linesMax; i++) {
            column.add(dataFormatter.formatCellValue(sheet.getRow(i).getCell(col)));
        }
        return column;
    }
    //Отлажено
    public Integer searchForColumn (Sheet sheet , String nameOfColumn , int lineForSearch, int colMax) {
        for (int i = 0; i < colMax; i++) {
            String dataInColumn = dataFormatter.formatCellValue(sheet.getRow(lineForSearch).getCell(i));
            if(dataInColumn.equals(nameOfColumn)) {
                return i;
            }
        }
        throw new RuntimeException("Такой колонки не существует = " + nameOfColumn);
    }
    //Отлажено
    public HashMap<String , ArrayList<String>> returnAllColumnsWithData (Sheet sheet , HashMap<String,String> paramsJuxtaposition,int colMax,int rowWhereFindNum,int linesMax) {
        HashMap<String , ArrayList<String>> allColumns = new HashMap<>();
        for (Map.Entry param : paramsJuxtaposition.entrySet()) {
            int columnNumberToFind = searchForColumn(sheet, String.valueOf(param.getValue()),rowWhereFindNum,colMax);
            allColumns.put(String.valueOf(param.getKey()),returnDataFormColumn(columnNumberToFind,linesMax,sheet,rowWhereFindNum));
        }
        return allColumns;
    }
    //Отлажено
    public ArrayList<HashMap<String,String>> returnParametersOfCards (HashMap<String , ArrayList<String>> columnsWithData,int linesMax,int rowWhereFindNum) {
        ArrayList<HashMap<String,String>> cards = new ArrayList<>();
        for (int i = 0; i < linesMax - (rowWhereFindNum+1); i++) {
            HashMap<String , String> card = new HashMap<>();
            for (Map.Entry column : columnsWithData.entrySet()) {
                ArrayList<String> data = (ArrayList)column.getValue();
                card.put(String.valueOf(column.getKey()),data.get(i));
            }
            cards.add(card);
        }
        return cards;
    }
    //Отлажено
    public Card cardFactory (HashMap<String,String> parametersOfCard) {
       Card card = new Card();
        for (Map.Entry parameter : parametersOfCard.entrySet()) {
            if(!parameter.getKey().equals("amount")){
                card.setValue(String.valueOf(parameter.getKey()),String.valueOf(parameter.getValue()));
            }
        }
        return card;
    }
    //Отлажено
    public ArrayList<Card> returnCards (ArrayList<HashMap<String,String>> parametersOfCards){
        ArrayList<Card> cards = new ArrayList<>();
        for (HashMap<String,String> parameterOfCard : parametersOfCards) {
            for (int i = 0; i < Integer.parseInt(parameterOfCard.get("amount")); i++) {
                cards.add(cardFactory(parameterOfCard));
            }
        }
        return cards;
    }

    public void importAllCardsFromExcel(File file, HashMap<String, String> params, int cellMaxNum,
                                        int rowWhereFindNum, int rowMaxNum, int numSheetInWorkBook, DataManager dataManager)
            throws FileNotFoundException, IOException {

        InputStream in = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(in);
        Sheet sheet = wb.getSheetAt(numSheetInWorkBook);

       HashMap<String,ArrayList<String>> column = returnAllColumnsWithData(sheet,params,cellMaxNum,rowWhereFindNum,rowMaxNum);
        ArrayList<HashMap<String,String>> parametersOfCards = returnParametersOfCards(column,rowMaxNum,rowWhereFindNum);
        ArrayList<Card> cards = returnCards(parametersOfCards);

        for (Card card : cards) {
            dataManager.commit(card);
        }
    }
}
