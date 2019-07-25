package com.company.regofcardsmagic.web.usersUI.cardsPull;

import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

public class Cardpullsearch extends AbstractWindow {
    @Inject
    private Button find;

    @Inject
    private CheckBox black;

    @Inject
    private CheckBox blue;

    @Inject
    private CheckBox bubna;

    @Inject
    private Button clear;

    Map<String,Object> params;

    @Inject
    private CheckBox colorless;

    @Inject
    private CheckBox common;

    @Inject
    private CheckBox white;

    @Inject
    private CheckBox uncommon;

    @Inject
    private TextField type;

    @Inject
    private TextField tourneyType;

    @Inject
    private TextField text;

    @Inject
    private CheckBox special;

    @Inject
    private CheckBox red;

    @Inject
    private CheckBox rare;

    @Named("painter text")
    private TextField painterText;

    @Inject
    private TextField painter;

    @Inject
    private TextField name;

    @Inject
    private CheckBox mythic;

    @Inject
    private CheckBox land;

    @Inject
    private CheckBox green;

    @Override
    public void init(Map<String, Object> params) {
        this.params = new HashMap<>();
        find.setAction(new AbstractAction("find") {
            @Override
            public void actionPerform(Component component) {
                params.put("green",green);
                params.put("land",land);
                params.put("mythic",mythic);
                params.put("name",name);
                params.put("painter",painter);
                params.put("painterText",painterText);
                params.put("rare",rare);
                params.put("red",red);
                params.put("special",special);
                params.put("text",text);
                params.put("tourneyType",tourneyType);
                params.put("type",type);
                params.put("uncommon",uncommon);
                params.put("white",white);
                params.put("common",common);
                params.put("colorless",colorless);
                params.put("bubna",bubna);
                params.put("blue",blue);
                params.put("black",black);

                openWindow("regofcardsmagic$Storage.browse", WindowManager.OpenType.NEW_TAB,params);
                close("this");
            }
        });
    }
}