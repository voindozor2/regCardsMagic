package com.company.regofcardsmagic.web.deck;

import com.company.regofcardsmagic.entity.Card;
import com.company.regofcardsmagic.entity.Deck;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;

public class DeckBrowse extends AbstractLookup {
    @Inject
    private VBoxLayout mainBoard;

    @Inject
    private VBoxLayout sideboard;

    @Inject
    private GroupTable<Deck> decksTable;

    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        decksTable.setItemClickAction(new AbstractAction("parse") {
            @Override
            public void actionPerform(Component component) {
                mainBoard.removeAll();
                sideboard.removeAll();
                decksTable.setMultiSelect(false);
                Deck deck = (Deck) decksTable.getSelected().iterator().next();
                Label labelMain = componentsFactory.createComponent(Label.class);
                labelMain.setValue("Mainboard : ");
                mainBoard.add(labelMain);

                Label labelSide = componentsFactory.createComponent(Label.class);
                labelSide.setValue("Sideboard : ");
                sideboard.add(labelSide);

                for (Card mainDeckCard:deck.getMaindeck()) {
                    Label label = componentsFactory.createComponent(Label.class);
                    label.setValue(mainDeckCard.getName());
                    mainBoard.add(label);
                }

                for (Card sideBoardCard : deck.getSideboard()) {
                    Label label = componentsFactory.createComponent(Label.class);
                    label.setValue(sideBoardCard.getName());
                    sideboard.add(label);
                }
            }
        });
    }
}