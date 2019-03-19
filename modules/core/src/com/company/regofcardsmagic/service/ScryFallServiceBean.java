package com.company.regofcardsmagic.service;

import forohfor.scryfall.api.Card;
import forohfor.scryfall.api.MTGCardQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(ScryFallService.NAME)
public class ScryFallServiceBean implements ScryFallService {
    
    public ArrayList<Card> searchForCards (String query) {
       return MTGCardQuery.search(query);
    }
}