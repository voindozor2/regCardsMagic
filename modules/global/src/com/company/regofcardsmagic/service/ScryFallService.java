package com.company.regofcardsmagic.service;

import forohfor.scryfall.api.Card;

import java.util.ArrayList;

public interface ScryFallService {
    String NAME = "regofcardsmagic_ScryFallService";
    public ArrayList<Card> searchForCards (String query);
}