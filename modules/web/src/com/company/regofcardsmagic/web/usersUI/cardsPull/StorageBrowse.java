package com.company.regofcardsmagic.web.usersUI.cardsPull;

import com.company.regofcardsmagic.entity.Card;
import com.company.regofcardsmagic.entity.CardScryFall;
import com.company.regofcardsmagic.entity.CollectionOfCards;
import com.company.regofcardsmagic.entity.Storage;
import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.GroupDatasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class StorageBrowse extends AbstractLookup {
    @Inject
    private Button search;
    
    @Inject
    private GroupDatasource<CardScryFall, UUID> cardScryFallsDs;

    @Inject
    private GroupTable<Storage> storagesTable;

    @Inject
    private Metadata metadata;

    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        if(params!=null) {
         //TODO добавить сюда фильтр
        }

        search.setAction(new AbstractAction("search") {
            @Override
            public void actionPerform(Component component) {
                openWindow("cardPullSearch", WindowManager.OpenType.NEW_TAB);
                close("this");
            }
        });
    }

    @Override
    public void ready() {
        super.ready();
        for (MetaProperty metaProperty : metadata.create(CardScryFall.class).getMetaClass().getOwnProperties()) {
            storagesTable.addGeneratedColumn(metaProperty.getName(),new Table.ColumnGenerator(){
                @Override
                public Component generateCell(Entity entity) {
                    Card card = (Card) entity;
                    Label field = (Label)componentsFactory.createComponent(Label.NAME);
                    cardScryFallsDs.setQuery("select e from regofcardsmagic$CardScryFall e where e.name = "+card.getName()+"");
                    cardScryFallsDs.refresh();
                    field.setValue(cardScryFallsDs.getItem().getValue(metaProperty.getName()));
                    return field;
                }
            });
        }

    }
}