package com.company.regofcardsmagic.web.importFromExcel;

import com.company.regofcardsmagic.entity.Card;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import io.swagger.models.auth.In;

import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Importdecklist extends AbstractWindow {
    @Inject
    private HBoxLayout buttons;

    @Inject
    private ResizableTextArea decklist;

    @Inject
    private ResizableTextArea guide;

    @Inject
    private VBoxLayout labels;

    @Inject
    private GridLayout mainLayout;

    @Inject
    private Button check;

    @Inject
    private DataManager dataManager;

    @Inject
    private Button start;

    @Inject
    private ComponentsFactory componentsFactory;

    String decklistText = new String();
    HashMap<String,Integer> missingCards = new HashMap<>();
    ArrayList<Card> cardsToCommit = new ArrayList<>();

    public ArrayList<String> parseDeckToLines (String deck) {
        ArrayList<String> lines = new ArrayList<>();
        int prevValue = 0 ;
         for (int i = 0; i < deck.length() ; i++) {
            if(deck.codePointAt(i)==10) {
                lines.add(deck.substring(prevValue,i));
                prevValue = i+1 ;
            }
        }
        return lines;
    }

    public boolean isNumeric (int codepoint) {
        if((codepoint >=  48 ) && (codepoint <= 57)) {
            return true;
        }
        return false;
    }

    public HashMap<String,Integer> parseLinesToCardsAndAmount (ArrayList<String> lines) {
        HashMap<String,Integer> cardsAndAmount = new HashMap<>();
        for (String line : lines) {
            int iterator = 0;
            if(!line.equals("--Mainboard") && !line.equals("--Sideboard"))  {
                try {
                    while(isNumeric(line.codePointAt(iterator))){
                        iterator++;
                    }
                    Integer amount = Integer.parseInt(line.substring(0,iterator));
                    while(line.codePointAt(iterator)==32) {
                        iterator++;
                    }
                    String nameOfCard = line.substring(iterator,line.length());
                    String newNameOfCard = nameOfCard;
                    int g=nameOfCard.length();
                    for (int i = nameOfCard.length()-1; i > 0 ; i--) {
                        if(nameOfCard.codePointAt(i)==32) {
                            g--;
                        }
                        else {
                            newNameOfCard = nameOfCard.substring(0,g);
                            i = 0;
                        }
                    }
                    if(cardsAndAmount.containsKey(newNameOfCard)) {
                        Integer prevAmount = (Integer) cardsAndAmount.get(newNameOfCard);
                        cardsAndAmount.put(newNameOfCard,prevAmount+amount);
                    }
                    else {
                        cardsAndAmount.put(newNameOfCard, amount);
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Неправильный формат деклиста!");
                }
            }
        }
        return cardsAndAmount;
    }

    List<Card> downloadCardsWithSameName (String name) {
        ArrayList<Card> cardsWithSameName = new ArrayList<>();
        LoadContext<Card> loadContext = LoadContext.create(Card.class);
        loadContext.setQuery(LoadContext.createQuery("select e from regofcardsmagic$Card e where Upper(e.name) = Upper(:name)").setParameter("name",name)).setView("card-view");
        return dataManager.loadList(loadContext);
    }

    @Override
    public void init(Map<String, Object> params) {
        start.setEnabled(false);

        guide.setValue("" +
                "Пожалуйста , используйте следуйщий формат для импорта деклиста\n" +
                "--Mainboard\n" +
                "2 Dovin, Grand Arbiter \n" +
                "4 Thought Erasure \n" +
                "4 Discovery // Dispersal\n" +
                "4 Mortify \n" +
                "2 Lyra Dawnbringer \n" +
                "2 Hostage Taker \n" +
                "3 Thief of Sanity \n" +
                "3 Seraph of the Scales \n" +
                "4 Hero of Precinct One \n" +
                "4 Deputy of Detention\n" +
                "--Sideboard\n" +
                "2 Hostage Taker \n" +
                "3 Thief of Sanity \n" +
                "В конце деклиста обязательно должен стоять ENTER");

        guide.setEditable(false);

    check.setAction(new AbstractAction("asd") {
        @Override
        public void actionPerform(Component component) {
           decklistText = ((String) decklist.getValue());
           decklistText = decklistText + "\n";
           boolean missingCards = false;

            ArrayList<String> lines =  parseDeckToLines(decklistText);
            HashMap<String,Integer> linesOfCardsAndAmount = parseLinesToCardsAndAmount(lines);
            ArrayList<Card> cardsToCommit = new ArrayList<>();
            HashMap<String,Integer> cardsMissing = new HashMap<>();
            HashMap<String,Integer> cardsToKeep = new HashMap<>();
            for (Map.Entry cardAndAmount : linesOfCardsAndAmount.entrySet()) {
                List<Card> cards = downloadCardsWithSameName(String.valueOf(cardAndAmount.getKey()));
                cardsMissing.put(String.valueOf(cardAndAmount.getKey()),0);
                cardsToKeep.put(String.valueOf(cardAndAmount.getKey()),0);
                for (Card card : cards) {
                    if(card.getDeck()!=null) {
                        continue;
                    }
                    else {
                        if(cardsToKeep.get(cardAndAmount.getKey()) != cardAndAmount.getValue()) {
                            Integer amount = cardsToKeep.get(cardAndAmount.getKey()) + 1;
                            cardsToKeep.put(String.valueOf(cardAndAmount.getKey()),amount);
                        }
                    }
                }
                if(cardsToKeep.get(cardAndAmount.getKey()) != cardAndAmount.getKey()) {
                    Integer amount = (Integer) cardAndAmount.getValue() - cardsToKeep.get(cardAndAmount.getKey());
                    cardsMissing.put((String) cardAndAmount.getKey(),amount);
                }
            }
            for (Map.Entry cardMissing : cardsMissing.entrySet()) {
                if((Integer)cardMissing.getValue()!=0){
                    missingCards = true;
                }
            }
            if(!missingCards) {
                start.setEnabled(true);
            }
            else {
                Label labelMis = componentsFactory.createComponent(Label.class);
                labelMis.setValue("Missing cards :");
                labels.add(labelMis);
                for (Map.Entry missingCard : cardsMissing.entrySet()) {
                    if((Integer)missingCard.getValue()!=0) {
                        Label label = componentsFactory.createComponent(Label.class);
                        label.setValue(missingCard.getKey() + "=" + missingCard.getValue());
                        labels.add(label);
                    }
                }
            }
        }
    });
    }

}