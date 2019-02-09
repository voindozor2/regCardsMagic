package com.company.regofcardsmagic.web.importFromExcel;

import com.company.regofcardsmagic.entity.Card;
import com.company.regofcardsmagic.service.RegCardsService;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.datatypes.impl.IntegerDatatype;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaProperty;
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
import java.util.ArrayList;
import java.util.Collection;
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

    private ArrayList<String> idTextFields = new ArrayList<>();

    @Override
    public void init(Map<String, Object> params) {
        HashMap<String,String> param = new HashMap<String, String>(); // первое значение в базе , второе значение в экселе
        MetaClass card = metadata.getClass(Card.class);
        Collection<MetaProperty> properties =  card.getOwnProperties();
        for (MetaProperty metaProperty:properties) {
            TextField textField = (TextField) componentsFactory.createComponent(TextField.NAME);
            textField.setId(metaProperty.getName());
            textField.setCaption(metaProperty.getName());
            idTextFields.add(metaProperty.getName());
            generatorParams.add(textField);
        }
        TextField textField = (TextField) componentsFactory.createComponent(TextField.NAME);
        textField.setId("amount");
        textField.setCaption("amount");
        idTextFields.add("amount");
        generatorParams.add(textField);
        upload.addFileUploadSucceedListener(event -> {
         file = fileUploadingAPI.getFile(upload.getFileId());
        });


        

        button.setAction(new AbstractAction("asd") {
            @Override
            public void actionPerform(Component component) {
                try {
                    if(rowWhereFind.getValue()==null || SheetInWorkBook.getValue()==null || rowMax.getValue()==null ||
                            cellMax.getValue() == null) {
                    showNotification("Введите значения в форму!");
                    for (String idTextField : idTextFields) {
                       TextField textField = (TextField) getComponent(idTextField);
                       if(textField.getValue()==null) {
                           showNotification("Введите значения в поле"+ textField.getCaption() +"!");
                       }
                    }
                    }

                    /*else if (!rowWhereFind.getDatatype().equals(PixelFormat.DataType.INT) ||
                            !SheetInWorkBook.getDatatype().equals(PixelFormat.DataType.INT) ||
                            !rowMax.getDatatype().equals(PixelFormat.DataType.INT) ||
                            !cellMax.getDatatype().equals(PixelFormat.DataType.INT)) {
                        showNotification("Введите числа в поля!");

                    }*/ //TODO сделать чтобы отслеживалось введение в поля не чисел (тип integer)
                   else {
                        for (String id : idTextFields) {
                            TextField field = (TextField) getComponentNN(id);
                            if(field.getValue()!=null) {
                                param.put(field.getCaption(),field.getValue());
                            }
                        }
                        regCardsService.importFromExcel(file,param ,Integer.parseInt(cellMax.getValue()),Integer.parseInt(rowWhereFind.getValue())
                                ,Integer.parseInt(rowMax.getValue()),Integer.parseInt(SheetInWorkBook.getValue()));
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