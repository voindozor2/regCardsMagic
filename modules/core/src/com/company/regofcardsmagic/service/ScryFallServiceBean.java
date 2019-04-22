package com.company.regofcardsmagic.service;

import com.company.regofcardsmagic.entity.CardScryFall;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import forohfor.scryfall.api.Card;
import forohfor.scryfall.api.CardReference;
import forohfor.scryfall.api.MTGCardQuery;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service(ScryFallService.NAME)
public class ScryFallServiceBean implements ScryFallService {
    @Inject
    private DataManager dataManager;
    @Inject
    private Metadata metadata;


    @Override
    public void importAllCardsFromScryFall() {
        ArrayList<String> rarities = new ArrayList<>();
        rarities.add("common");
        rarities.add("uncommon");
        rarities.add("mythic");
        rarities.add("rare");
        String querys = null;
        for (String rarity:rarities) {
            querys = "r:"+rarity;
            ArrayList<Card> cards = MTGCardQuery.search(querys);

            for (Card card:cards) {
                CardScryFall cardScryFall = metadata.create(CardScryFall.class);
                cardScryFall.setArtist(card.getArtist());
                cardScryFall.setBorder(card.getBorder());
                //cardScryFall.setCannonicalImage(card.getCannonicalImage().toString());//TODO
                //cardScryFall.setCannonicalImageURI(card.getCannonicalImageURI());//TODO
                cardScryFall.setCmc(card.getCmc());
                cardScryFall.setCollectorNumber(card.getCollectorNumber());
                if(card.getColorIdentity()!=null) {
                    cardScryFall.setColorIdentity(card.getColorIdentity().toString());
                }

                if(card.getColors()!=null) {
                    cardScryFall.setColors(card.getColors().toString());
                }

                if(card.getFaces()!=null) {
                    cardScryFall.setFaces(card.getFaces().toString());
                }
                cardScryFall.setScryfallUUID(card.getScryfallUUID());
                cardScryFall.setFlavorText(card.getFlavorText());
                cardScryFall.setFrame(card.getFrame());
                cardScryFall.setImageURI(card.getImageURI());
                cardScryFall.setLayout(card.getLayout());
                cardScryFall.setLoyalty(card.getLoyalty());
                cardScryFall.setManaCost(card.getManaCost());
                cardScryFall.setMultiverseID(card.getMultiverseID());
                cardScryFall.setOracleText(card.getOracleText());
                cardScryFall.setPower(card.getPower());
                cardScryFall.setMtgoId(card.getMtgoID());
                cardScryFall.setPriceTix(card.getPriceTix());
                cardScryFall.setPriceUsd(card.getPriceUsd());
                cardScryFall.setRarity(card.getRarity());
                cardScryFall.setScryfallUri(card.getScryfallUri());
                cardScryFall.setSetCode(card.getSetCode());
                cardScryFall.setSetName(card.getSetName());
                cardScryFall.setToughness(card.getToughness());
                cardScryFall.setName(card.getName());
                cardScryFall.setTypeLine(card.getTypeLine());
                cardScryFall.setIsColorShifted(card.isColorShifted());
                cardScryFall.setIsDigitalOnly(card.isDigitalOnly());
                cardScryFall.setIsFutureShifted(card.isFutureShifted());
                cardScryFall.setIsMultifaced(card.isMultifaced());
                cardScryFall.setIsMultiPart(card.isMultiPart());
                cardScryFall.setIsReserved(card.isReserved());
                cardScryFall.setIsTimeShifted(card.isTimeShifted());
                cardScryFall.setLegality_Legacy(card.getLegality("Legacy"));
                cardScryFall.setLegality_Modern(card.getLegality("Modern"));
                cardScryFall.setLegality_Standart(card.getLegality("Standard"));
                cardScryFall.setLegality_Vintage(card.getLegality("Vintage"));
                dataManager.commit(cardScryFall);
            }
        }

    }
}