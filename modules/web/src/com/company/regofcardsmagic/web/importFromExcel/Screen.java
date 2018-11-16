package com.company.regofcardsmagic.web.importFromExcel;

import com.company.regofcardsmagic.service.RegCardsService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

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
    @Override
    public void init(Map<String, Object> params) {
        upload.addFileUploadSucceedListener(event -> {
         file = fileUploadingAPI.getFile(upload.getFileId());
        });

        button.setAction(new AbstractAction("asd") {
            @Override
            public void actionPerform(Component component) {
                try {
                    regCardsService.importFromExcel(file, new HashMap<String, String>(),10,1,10);
                }catch (FileNotFoundException e) {

                }catch (IOException e) {

                }

                }
        });

    }
}