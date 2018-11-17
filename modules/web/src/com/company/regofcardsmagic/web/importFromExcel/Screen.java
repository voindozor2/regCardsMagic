package com.company.regofcardsmagic.web.importFromExcel;

import com.company.regofcardsmagic.entity.Card;
import com.company.regofcardsmagic.service.RegCardsService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.oracle.jrockit.jfr.DynamicValue;
import com.sun.prism.PixelFormat;

import javax.inject.Inject;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Screen extends AbstractWindow {
    @Inject
    private Label label;

    @Inject
    private FileUploadField upload;

    @Inject
    private FileUploadingAPI fileUploadingAPI;

    @Inject
    private Button button;

    private FileDescriptor fd;

    @Inject
    private RegCardsService regCardsService;

    @Inject
    private FileLoader fileLoader;

    @Inject
    private DataManager dataManager;

    private File file;

    @Inject
    private TextField cellMax;

    @Inject
    private VBoxLayout generatorParams;

    @Inject
    private TextField rowMax;

    @Inject
    private TextField rowWhereFind;

    @Inject
    private TextField SheetInWorkBook;

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private Metadata metadata;

    @Override
    public void init(Map<String, Object> params) {
        HashMap<String,String> param = new HashMap<String, String>();
        upload.addFileUploadSucceedListener(event -> {
         file = fileUploadingAPI.getFile(upload.getFileId());
        });

        Card testCard = metadata.create(Card.class);
        

        button.setAction(new AbstractAction("asd") {
            @Override
            public void actionPerform(Component component) {
                try {
                    if(rowWhereFind.getValue()==null || SheetInWorkBook.getValue()==null || rowMax.getValue()==null ||
                            cellMax.getValue() == null) {
                    showNotification("Введите значения в форму!");
                    }
                    else if (!rowWhereFind.getDatatype().equals(PixelFormat.DataType.INT) ||
                            !SheetInWorkBook.getDatatype().equals(PixelFormat.DataType.INT) ||
                            !rowMax.getDatatype().equals(PixelFormat.DataType.INT) ||
                            !cellMax.getDatatype().equals(PixelFormat.DataType.INT)) {
                        showNotification("Введите числа в поля!");

                    }else {
                        regCardsService.importFromExcel(file,param ,cellMax.getValue(),rowWhereFind.getValue()
                                ,rowMax.getValue(),SheetInWorkBook.getValue());
                    }

                }catch (FileNotFoundException e) {
                   e.printStackTrace();
                }catch (IOException e) {
                    e.printStackTrace();
                }

                }
        });

    }
}