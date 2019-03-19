package com.company.regofcardsmagic.web.usersUI.cardsPull;

import com.company.regofcardsmagic.service.ApiScryFallService;
import com.haulmont.cuba.gui.components.*;

import javax.inject.Inject;
import java.util.Map;

public class CardspullBrowse extends AbstractWindow {
    @Inject
    private TextField name;

    @Inject
    private Button find;

    @Inject
    private ApiScryFallService apiScryFallService;

    @Override
    public void init(Map<String, Object> params) {
        find.setAction(new AbstractAction("find") {
            @Override
            public void actionPerform(Component component) {

            }
        });
    }
}