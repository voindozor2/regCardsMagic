package com.company.regofcardsmagic.web.importFromExcel;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;
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

    @Override
    public void init(Map<String, Object> params) {
        upload.addFileUploadSucceedListener(event -> {
            fd = upload.getFileDescriptor();
        });

        button.setAction(new AbstractAction("asd") {
            @Override
            public void actionPerform(Component component) {
                }
        });

        upload.addFileUploadErrorListener(event -> {
            showNotification("File upload error", NotificationType.HUMANIZED);

        });
    }
}