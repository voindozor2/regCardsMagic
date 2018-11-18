package com.company.regofcardsmagic.core;

import com.company.regofcardsmagic.entity.Card;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.AppBeans;
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

    public String returnColumn (Sheet sheet , int rowNum , int cellNum ) {
        return sheet.getRow(rowNum).getCell(cellNum).toString();
    }

    public Integer searchForParametrColumn (Sheet sheet , String parameter , int rowWhereFindNum) {
        for (Cell cell:sheet.getRow(rowWhereFindNum)) {
            if(cell.toString().equals(parameter)){
                return cell.getColumnIndex();
            }
        }
        return null;
    }

    public HashMap<String,String> returnRow (Sheet sheet , HashMap<String, String> params ,
                                             int rowNum , int rowWhereFindNum) {
        HashMap<String,String> result = new HashMap<>();
        for(Map.Entry mapEntry : params.entrySet()) {
            //Ищем в какой колонке находится тот или иной параметр , и распихиваем их по HashMap'y
            if(searchForParametrColumn(sheet,mapEntry.getValue().toString(),rowWhereFindNum)!=null) {
                result.put(mapEntry.getKey().toString(),
                        returnColumn(sheet,rowNum,searchForParametrColumn(sheet,mapEntry.getValue()
                                .toString(),rowWhereFindNum)).toString());
            }
        }
        return result;
    }

    public Card generateCard (HashMap<String,String> params) {
        Card card = new Card();
        for (Map.Entry mapEntry : params.entrySet() ) {
            if(mapEntry.getKey().toString().equals("amount")) {
                continue;
            }
            else {
                card.setValue(mapEntry.getKey().toString() , mapEntry.getValue().toString());
            }

        }
        return card;
    }

    public ArrayList<Card> cardsFactory (HashMap<String , HashMap<String , String>> allcards) {
      ArrayList<Card> cards = new ArrayList<>();

        for (Map.Entry mapEntry : allcards.entrySet()) {
            HashMap<String,String> card = (HashMap<String, String>) mapEntry.getValue();

            for (int amount = 0; amount < Integer.parseInt(card.get("amount")); amount++) {
                cards.add(generateCard(card));
            }
        }

      return cards;
    }

    public ArrayList<Card> returnAllCardsFromExcel (Sheet sheet ,
                                                    HashMap<String, String> params,
                                                    int cellMaxNum , int rowWhereFindNum,
                                                    int rowMaxNum) {
        HashMap<String,HashMap<String,String>> result = new HashMap<>();
        String name = null;
        for (int rowNum = 0; rowNum < rowMaxNum; rowNum++) {

            for (Map.Entry mapEntry : returnRow(sheet,params,rowNum,rowWhereFindNum).entrySet()) {
                if(mapEntry.getKey().equals("name")) {
                    name = mapEntry.getValue().toString();
                }
            }
            result.put(name,returnRow(sheet,params,rowNum,rowWhereFindNum));
        }
        return cardsFactory(result);
    }

    public void insertCardsToDatabase () {

    }
    public void importAllCardsFromExcel(File file, HashMap<String, String> params, int cellMaxNum,
                                                   int rowWhereFindNum, int rowMaxNum,int numSheetInWorkBook)
            throws FileNotFoundException, IOException {

        params.put("name", "Наименование");
        params.put("amount","Количество" );
        InputStream in = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(in);
        Sheet sheet = wb.getSheetAt(numSheetInWorkBook);
        DataFormatter dataFormatter = new DataFormatter();

    }
}
