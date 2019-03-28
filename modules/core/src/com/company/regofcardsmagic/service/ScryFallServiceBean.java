package com.company.regofcardsmagic.service;

import forohfor.scryfall.api.Card;
import forohfor.scryfall.api.CardReference;
import forohfor.scryfall.api.MTGCardQuery;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service(ScryFallService.NAME)
public class ScryFallServiceBean implements ScryFallService {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public void importAllCardsFromScryFall() {
        try {
            Class.forName("org.postgresql.Driver");
            String servername = "localhost:5432";
            String database = "testDataBase";
            String url = "jdbc:postgresql://" + servername + "/" + database;
            String login = "postgres";
            String password = "postgres";
            String nameOfTable = "cards_scryfall";
            create_table(url, login, password, nameOfTable);
            ArrayList<String> querys = new ArrayList<>();
            querys.add("year<=1994");
            querys.add("year=1994");
            querys.add("year=1995");
            querys.add("year=1996");
            querys.add("year=1997");
            querys.add("year=1998");
            querys.add("year=1999");
            querys.add("year=2000");
            querys.add("year=2001");
            querys.add("year=2002");
            querys.add("year=2003");
            querys.add("year=2004");
            querys.add("year=2005");
            querys.add("year=2006");
            querys.add("year=2007");
            querys.add("year=2008");
            querys.add("year=2009");
            querys.add("year=2010");
            querys.add("year=2011");
            querys.add("year=2012");
            querys.add("year=2013");
            querys.add("year=2014");
            querys.add("year=2015");
            querys.add("year=2016");
            querys.add("year=2017");
            querys.add("year=2018");
            querys.add("year=2019");
            int card_id = 0;
            for (String query:querys){
                //String query = "game:paper";
                ArrayList<Card> cards = MTGCardQuery.search(query);

                ArrayList<HashMap<String, Object>> arrayHashmapCards = new ArrayList<>();
                for (Card card : cards) {
                    HashMap<String, Object> update = new HashMap<>();
                    update.put("card_id", card_id++);
                    update.put("Name", card.getName());
                    //update.put("MtgoId", card.getMtgoID());
                    update.put("MtgoId", 0);
                    //update.put("ScryfallUUID", card.getScryfallUUID());
                    update.put("ScryfallUUID", 0);
                    update.put("Artist", card.getArtist());
                    update.put("Border", card.getBorder());
//                update.put("CannonicalImage",  card.getCannonicalImage());
                    update.put("CannonicalImage", null);
                    update.put("CannonicalImageURI", card.getCannonicalImageURI());
                    //update.put("Cmc", card.getCmc());
                    update.put("Cmc", 0);
                    update.put("CollectorNumber", card.getCollectorNumber());
                    //update.put("ColorIdentity", card.getColorIdentity().toString());//TODO
                    update.put("ColorIdentity", null);
                    //update.put("Colors", card.getColors().toString());//TODO
                    update.put("Colors", null);
                    //update.put("Faces",   card.getFaces().toArray().toString());//TODO
                    update.put("Faces", null);
                    update.put("Faces", "Faces is null");
                    update.put("FlavorText", card.getFlavorText());
                    update.put("Frame", card.getFrame());
                    update.put("ImageURI", card.getImageURI());
                    update.put("Layout", card.getLayout());
                    update.put("Loyalty", card.getLoyalty());
                    update.put("ManaCost", card.getManaCost());
                    //update.put("MultiverseID", card.getMultiverseID());
                    update.put("MultiverseID", "0");
                    update.put("OracleText", card.getOracleText());
                    update.put("Power", card.getPower());
                    //update.put("PriceTix", card.getPriceTix());
                    update.put("PriceTix", 0);
                    //update.put("PriceUsd", card.getPriceUsd());
                    update.put("PriceUsd", 0);
                    update.put("Rarity", card.getRarity());
                    update.put("ScryfallUri", card.getScryfallUri());
                    update.put("SetCode", card.getSetCode());
                    update.put("SetName", card.getSetName());
                    update.put("Toughness", card.getToughness());
                    update.put("TypeLine", card.getTypeLine());
                    //update.put("isColorShifted", card.isColorShifted());
                    update.put("isColorShifted", false);
                    //update.put("isDigitalOnly",  card.isDigitalOnly());
                    update.put("isDigitalOnly", false);
                    //update.put("isFutureShifted", card.isFutureShifted());
                    update.put("isFutureShifted", false);
                    //update.put("isMultifaced",card.isMultifaced());
                    update.put("isMultifaced", false);
                    //update.put("isMultiPart",card.isMultiPart());
                    update.put("isMultiPart", false);
                    //update.put("isReserved", card.isReserved());
                    update.put("isReserved", false);
                    //update.put("isTimeShifted",card.isTimeShifted());
                    update.put("isTimeShifted", false);
                    update.put("Legality_Legacy", card.getLegality("Legacy"));
                    update.put("Legality_Standart", card.getLegality("Standart"));
                    update.put("Legality_Modern", card.getLegality("Modern"));
                    update.put("Legality_Vintage", card.getLegality("Vintage"));
                    arrayHashmapCards.add(update);
                }

                update_table(url, login, password, nameOfTable, arrayHashmapCards);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void create_table(String url, String login, String password, String nameOfTable) throws SQLException {
        Connection connection = DriverManager.getConnection(url, login, password);
        try {
            String sql = "CREATE TABLE IF NOT EXISTS "+nameOfTable+"(" +
                    "card_id integer not null primary key ," +
                    "MtgoId integer," +
                    "Name varchar NOT NULL," +
                    "ScryfallUUID varchar," +
                    "Artist varchar," +
                    "Border varchar," +
                    "CannonicalImage varchar ," +
                    "CannonicalImageURI varchar,"+
                    "Cmc double precision," +
                    "CollectorNumber varchar," +
                    "ColorIdentity varchar," +
                    "Colors varchar," +
                    "Faces varchar," +
                    "FlavorText varchar," +
                    "Frame varchar," +
                    "ImageURI varchar," +
                    "Layout varchar," +
                    "Loyalty varchar," +
                    "ManaCost varchar," +
                    "MultiverseID integer," +
                    "OracleText varchar," +
                    "Power varchar," +
                    "PriceTix double precision," +
                    "PriceUsd double precision," +
                    "Rarity varchar," +
                    "ScryfallUri varchar," +
                    "SetCode varchar," +
                    "SetName varchar," +
                    "Toughness varchar," +
                    "TypeLine varchar," +
                    "isColorShifted bool," +
                    "isDigitalOnly BOOL," +
                    "isFutureShifted BOOL," +
                    "isMultifaced BOOL," +
                    "isMultiPart BOOL," +
                    "isReserved BOOL," +
                    "isTimeShifted BOOL," +
                    "Legality_Legacy varchar," +
                    "Legality_Standart varchar," +
                    "Legality_Modern varchar," +
                    "Legality_Vintage varchar);";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

    public static void update_table(String url, String login, String password, String nameOfTable, ArrayList<HashMap<String, Object>> toUpdateArrayList) throws SQLException {
        Connection connection = DriverManager.getConnection(url, login, password);

        boolean first = false;
        StringBuilder sql = new StringBuilder();

        try {
            for (HashMap<String, Object> toUpdate : toUpdateArrayList) {
                ArrayList<String> attributes = new ArrayList<>();
                ArrayList<Object> values = new ArrayList<>();
                for (Map.Entry toUpdateEntry : toUpdate.entrySet()) {
                    attributes.add((String) toUpdateEntry.getKey());
                    values.add(toUpdateEntry.getValue());
                }
                String atttributesString = new String("");
                String valuesString = new String("");

                if (!first) {
                    for (int j = 0; j < attributes.size(); j++) {
                        if (j == 0) {
                            atttributesString += attributes.get(j);
                        } else {
                            atttributesString += "," + attributes.get(j);
                        }
                    }
                    sql.append("INSERT INTO " + nameOfTable + "(" + atttributesString + ") VALUES");
                }

                for (int a = 0; a < values.size(); a++) {
                    String strong = String.valueOf(values.get(a));
                    if (strong.contains("'")) {
                        for (int i = 0; i < strong.length(); i++) {
                            if (strong.codePointAt(i) == 39) {
                                strong = strong.substring(0, i) + "'" + strong.substring(i, strong.length());
                                i++;
                            }
                        }
                        if (a == 0) {
                            valuesString = "'" + strong + "'";
                        } else {
                            valuesString += "," + "'" + strong + "'";
                        }
                    } else {
                        if (a == 0) {
                            valuesString = "'" + values.get(a) + "'";
                        } else {
                            valuesString += "," + "'" + values.get(a) + "'";
                        }
                    }

                }

                if (!first) {
                    sql.append("(" + valuesString + ")");
                    first = true;
                } else {
                    sql.append(",(" + valuesString + ")");
                    attributes.clear();
                    values.clear();
                }

            }


            Statement stmt = connection.createStatement();
            stmt.execute(sql.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}