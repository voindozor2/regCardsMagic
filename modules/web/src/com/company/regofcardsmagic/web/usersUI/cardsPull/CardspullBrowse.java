package com.company.regofcardsmagic.web.usersUI.cardsPull;

import com.company.regofcardsmagic.service.ApiScryFallService;
import com.company.regofcardsmagic.service.ScryFallService;
import com.haulmont.cuba.gui.components.*;
import forohfor.scryfall.api.Card;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Map;

public class CardspullBrowse extends AbstractWindow {
    @Inject
    private TextField name;

    @Inject
    private Button find;

    @Inject
    private ScryFallService scryFallService;

    @Override
    public void init(Map<String, Object> params) {
        find.setAction(new AbstractAction("find") {
            @Override
            public void actionPerform(Component component) {
               scryFallService.importAllCardsFromScryFall();
            }
        });
    }
}