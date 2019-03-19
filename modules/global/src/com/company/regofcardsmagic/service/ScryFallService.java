package com.company.regofcardsmagic.service;

import forohfor.scryfall.api.Card;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ScryFallService {
    String NAME = "regofcardsmagic_ScryFallService";
    void importAllCardsFromScryFall ();
}