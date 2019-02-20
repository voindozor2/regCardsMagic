package com.company.regofcardsmagic.web.deck;

import com.company.regofcardsmagic.entity.Card;
import com.haulmont.cuba.gui.components.*;
import com.company.regofcardsmagic.entity.Deck;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class DeckEdit extends AbstractEditor<Deck> {

    ArrayList<Card> mainBoardCards = new ArrayList<>();
    ArrayList<Card> sideBoardCards = new ArrayList<>();

    @Inject
    private Button add;

    @Inject
    private Table cards;

    @Inject
    private Table<Card> deck;

    @Inject
    private FieldGroup fieldGroup;

    @Inject
    private Frame windowActions;

    @Inject
    private Button remove;
    @Inject
    private CheckBox mainboardCheckBox;

    @Inject
    private CheckBox sideboardCheckBox;

    @Inject
    private CollectionDatasource<Card, UUID> cardsDs;

    @Inject
    private CollectionDatasource<Card, UUID> cardsToAddDs;

    @Inject
    private Datasource<Deck> deckDs;

    @Override
    protected boolean preCommit() {
        deckDs.getItem().setMaindeck(mainBoardCards);
        deckDs.getItem().setSideboard(sideBoardCards);
        return super.preCommit();
    }

    @Override
    public void init(Map<String, Object> params) {
        //TODO сделать чтобы он комитил в сущность эти самые листы

        add.setEnabled(false);
        cards.setMultiSelect(false);
        cardsToAddDs.clear();
        mainboardCheckBox.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChanged(ValueChangeEvent e) {
                sideboardCheckBox.setValue(false);
                cardsToAddDs.clear();
                for (Card mainBoardCard : mainBoardCards) {
                    cardsToAddDs.addItem(mainBoardCard);
                }
            }
        });

        sideboardCheckBox.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChanged(ValueChangeEvent e) {
                mainboardCheckBox.setValue(false);
                cardsToAddDs.clear();
                for (Card sideBoardCard : sideBoardCards) {
                    cardsToAddDs.addItem(sideBoardCard);
                }
            }
        });

        cards.setItemClickAction(new AbstractAction("asd") {
            @Override
            public void actionPerform(Component component) {
                if (!cards.getSelected().isEmpty()) {
                    add.setEnabled(true);
                }
                else {
                    add.setEnabled(false);
                }
            }
        });
        add.setAction(new AbstractAction("add") {
            @Override
            public void actionPerform(Component component) {
                if(mainboardCheckBox.getValue() || sideboardCheckBox.getValue() ) {
                    Card selectedCard = (Card) cards.getSelected().iterator().next();
                    cardsDs.excludeItem(selectedCard);
                    cardsToAddDs.addItem(selectedCard);

                    if(mainboardCheckBox.getValue()) {
                        mainBoardCards.add(selectedCard);
                    }
                    else if(sideboardCheckBox.getValue()) {
                        sideBoardCards.add(selectedCard);
                    }

                    if(mainboardCheckBox.getValue()) {
                        cardsToAddDs.addItem(selectedCard);
                        mainBoardCards.add(selectedCard);
                    }
                    else if(sideboardCheckBox.getValue()) {
                        cardsToAddDs.addItem(selectedCard);
                        sideBoardCards.add(selectedCard);
                    }
                }

            }
        });


    }
}