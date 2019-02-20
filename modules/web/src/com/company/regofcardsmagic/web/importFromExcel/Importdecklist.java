package com.company.regofcardsmagic.web.importFromExcel;

import com.company.regofcardsmagic.entity.Card;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.*;

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
    private LookupField deck;

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

    public List<Card> returnCardWithSameName (Collection<Card> cards,String nameOfCard) {
        ArrayList<Card> result = new ArrayList<>();

        for (Card card:cards) {
            if (card.getName().toUpperCase().equals(nameOfCard.toUpperCase())) {
                result.add(card);
            }
        }
        return result;
    }

    public HashMap<String,Integer> parseLinesToCardAndAmount(String line) {
        HashMap<String,Integer> cardsAndAmount = new HashMap<>();
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
        ArrayList<Card> cardsToCommit = new ArrayList<>();
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
            HashMap<String,Integer> linesOfCardsAndAmount = new HashMap<>();
            for (String line : lines) {
                HashMap<String,Integer> lineAndAmount = parseLinesToCardAndAmount(line);
                linesOfCardsAndAmount.putAll(lineAndAmount);
            }


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
                            cardsToCommit.add(card);
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
                for (Card cardToCommit:cardsToCommit) {
                    cardToCommit.setDeck(deck.getValue());
                }
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

    start.setAction(new AbstractAction("parse") {
        @Override
        public void actionPerform(Component component) {
            decklistText = ((String) decklist.getValue());
            decklistText = decklistText + "\n";
            ArrayList<String> lines =  parseDeckToLines(decklistText);
            ArrayList<Card> allCards = cardsToCommit;
            ArrayList<Card> mainboard = new ArrayList<>();
            ArrayList<Card> sideboard = new ArrayList<>();
            boolean main = false;
            boolean side = false;
            for (String line : lines) {
                if(line.equals("--Mainboard")) {
                    main = true;
                    side = false;
                }
                else if(line.equals("--Sideboard")){
                    main = false;
                    side = true;
                }

                HashMap<String ,Integer> cardAndAmount = parseLinesToCardAndAmount(line);

                Map.Entry entry = cardAndAmount.entrySet().iterator().next();
                String nameOfCard = (String) entry.getKey();
                Integer amount = (Integer) entry.getValue();
                if(main && !side) {
                    ArrayList<Card> sameCards = (ArrayList<Card>) returnCardWithSameName(allCards,nameOfCard);
                    for (int i = 0; i < amount; i++) {
                        mainboard.add(sameCards.get(i));
                        allCards.remove(sameCards.get(i));
                        sameCards.remove(sameCards.get(i));
                    }
                }
                else if (!main && side) {
                    ArrayList<Card> sameCards = (ArrayList<Card>) returnCardWithSameName(allCards,nameOfCard);
                    for (int i = 0; i < amount; i++) {
                        sideboard.add(sameCards.get(i));
                        allCards.remove(sameCards.get(i));
                        sameCards.remove(sameCards.get(i));
                    }
                }
            }
        }
    });
    }

}