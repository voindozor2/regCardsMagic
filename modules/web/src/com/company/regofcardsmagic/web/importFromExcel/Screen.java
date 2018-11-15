package com.company.regofcardsmagic.web.importFromExcel;

import com.company.regofcardsmagic.service.RegCardsService;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.components.*;
    import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    private DataManager dataManager;

    @Override
    public void init(Map<String, Object> params) {

        upload.addFileUploadSucceedListener(event -> {
            try {
                fileUploadingAPI.putFileIntoStorage(upload.getFileId(),upload.getFileDescriptor());
            } catch (FileStorageException e) {
                throw new RuntimeException(e);
            }
        });

        button.setAction(new AbstractAction("asd") {
            @Override
            public void actionPerform(Component component) {
                try {
                    regCardsService.importFromExcel(fd);
                }catch (IOException e) {
               e.printStackTrace();
                }
                catch (FileStorageException e){
                    e.printStackTrace();
                }

                }
        });

        upload.addFileUploadErrorListener(event -> {
            showNotification("File upload error", NotificationType.HUMANIZED);

        });
    }
}