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

            String query = "rarity:mythic";
            ArrayList<Card> cards = MTGCardQuery.search(query);

            ArrayList<HashMap<String, Object>> arrayHashmapCards = new ArrayList<>();
            for (Card card : cards) {
                Integer cardMtgoId;
                if (card.getMtgoID() == null) {
                    cardMtgoId = -1;
                } else {
                    cardMtgoId = card.getMtgoID();
                }
                HashMap<String, Object> update = new HashMap<>();
                update.put("Name", card.getName());
                update.put("MtgoId", cardMtgoId);
                update.put("ScryfallUUID", card.getScryfallUUID());
                update.put("Artist", card.getArtist());
                update.put("Border", card.getBorder() );
//                update.put("CannonicalImage",  card.getCannonicalImage());
                update.put("CannonicalImageURI", card.getCannonicalImageURI());
                update.put("Cmc", card.getCmc());
                update.put("CollectorNumber",  card.getCollectorNumber());
                update.put("ColorIdentity", card.getColorIdentity().toString());//TODO
                update.put("Colors", card.getColors().toString());//TODO
                update.put("Faces",   card.getFaces().toArray().toString());//TODO
                update.put("FlavorText", card.getFlavorText() );
                update.put("Frame",  card.getFrame());
                update.put("ImageURI",  card.getImageURI());
                update.put("Layout", card.getLayout());
                update.put("Loyalty",  card.getLoyalty() );
                update.put("ManaCost", card.getManaCost());
                update.put("MultiverseID", card.getMultiverseID());
                update.put("OracleText",  card.getOracleText());
                update.put("Power",  card.getPower());
                update.put("PriceTix", card.getPriceTix());
                update.put("PriceUsd", card.getPriceUsd());
                update.put("Rarity",  card.getRarity());
                update.put("ScryfallUri", card.getScryfallUri());
                update.put("SetCode",  card.getSetCode());
                update.put("SetName",  card.getSetName());
                update.put("Toughness", card.getToughness());
                update.put("TypeLine", card.getTypeLine());
                update.put("isColorShifted", card.isColorShifted());
                update.put("isDigitalOnly",  card.isDigitalOnly());
                update.put("isFutureShifted", card.isFutureShifted() );
                update.put("isMultifaced",card.isMultifaced() );
                update.put("isMultiPart",card.isMultiPart() );
                update.put("isReserved", card.isReserved() );
                update.put("isTimeShifted",card.isTimeShifted() );
                update.put("Legality_Legacy", card.getLegality("Legacy"));
                update.put("Legality_Standart", card.getLegality("Standart"));
                update.put("Legality_Modern", card.getLegality("Modern"));
                update.put("Legality_Vintage", card.getLegality("Vintage"));
                    arrayHashmapCards.add(update);
            }

            update_table(url, login, password, nameOfTable, arrayHashmapCards);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void create_table(String url, String login, String password, String nameOfTable) throws SQLException {
        Connection connection = DriverManager.getConnection(url, login, password);
        try {
            String sql = "CREATE TABLE IF NOT EXISTS " + nameOfTable + " (" +
                    "MtgoId bigserial ," +
                    "Name varchar NOT NULL,"+
                    "ScryfallUUID varchar,"+
                    "Artist varchar,"+
                    "Border varchar,"+
//                    "CannonicalImage image,"+
                    "CannonicalImageURI varchar,"+
                    "Cmc double,"+
                    "CollectorNumber varchar,"+
                    "ColorIdentity varchar,"+
                    "Colors varchar,"+
                    "Faces varchar,"+
                    "FlavorText varchar,"+
                    "Frame varchar,"+
                    "ImageURI varchar,"+
                    "Layout varchar,"+
                    "Loyalty varchar,"+
                    "ManaCost varchar,"+
                    "MultiverseID bigserial,"+
                    "OracleText varchar,"+
                    "Power varchar,"+
                    "PriceTix double,"+
                    "PriceUsd double,"+
                    "Rarity varchar,"+
                    "ScryfallUri varchar,"+
                    "SetCode varchar,"+
                    "SetName varchar,"+
                    "Toughness varchar,"+
                    "TypeLine varchar,"+
                    "isColorShifted BOOLEAN,"+
                    "isDigitalOnly BOOLEAN,"+
                    "isFutureShifted BOOLEAN,"+
                    "isMultifaced BOOLEAN,"+
                    "isMultiPart BOOLEAN,"+
                    "isReserved BOOLEAN,"+
                    "isTimeShifted BOOLEAN,"+
                    "Legality_Legacy varchar,"+
                    "Legality_Standart varchar,"+
                    "Legality_Modern varchar,"+
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
        String sql = null;

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
                    sql = "INSERT INTO " + nameOfTable + "(" + atttributesString + ") VALUES";
                }


                for (int a = 0; a < values.size(); a++) {
                    String strong = String.valueOf(values.get(a));
                    if (strong.contains("'")) {
                        for (int i = 0; i < strong.length(); i++) {
                            if (strong.codePointAt(i) == 39) {
                                strong = strong.substring(0, i) + "'" + strong.substring(i, strong.length());
                                break;
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
                    sql += "(" + valuesString + ")";
                    first = true;
                } else {
                    sql += ",(" + valuesString + ")";
                    attributes.clear();
                    values.clear();
                }

            }


            Statement stmt = connection.createStatement();
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}