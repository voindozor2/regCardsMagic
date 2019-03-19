package com.company.regofcardsmagic.service;

import forohfor.scryfall.api.Card;
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

    public void importAllCardsFromScryFall () {
        try {
            Class.forName("org.postgresql.Driver");
            String servername = "localhost:5432";
            String database = "testDataBase";
            String url = "jdbc:postgresql://"+servername+"/"+database;
            String login = "postgres";
            String password = "postgres";
            String nameOfTable = "cards_scryfall";
            create_table(url,login,password,nameOfTable);

            String query = "rarity:mythic";
            ArrayList<Card> cards = MTGCardQuery.search(query);

            ArrayList<HashMap<String,String>> arrayHashmapCards = new ArrayList<>();
            for (Card card:cards) {
                HashMap<String,String> update = new HashMap<>();
                update.put("name",card.getName());
                update.put("card_id", String.valueOf(card.getMtgoID()));
                arrayHashmapCards.add(update);
            }

            for (HashMap<String,String> hashMap:arrayHashmapCards) {
                update_table(url,login,password,nameOfTable,hashMap);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void create_table(String url , String login , String password,String nameOfTable) throws SQLException {
        Connection connection = DriverManager.getConnection(url,login,password);
        try {
            String sql = "CREATE TABLE IF NOT EXISTS "+nameOfTable+" (" +
                    "card_id bigserial NOT NULL," +
                    "name varchar NOT NULL);";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

    }

    public static void update_table (String url , String login , String password, String nameOfTable, HashMap<String,String> toUpdate) throws SQLException {
        Connection connection = DriverManager.getConnection(url,login,password);
        ArrayList<String> attributes = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        try {
            for (Map.Entry toUpdateArray:toUpdate.entrySet()) {
                attributes.add((String) toUpdateArray.getKey());
                values.add((String) toUpdateArray.getValue());
            }
            String attibutesString = attributes.toString().substring(1,attributes.toString().length()-1);
            String valuesString = values.toString().substring(1,values.toString().length()-1);
            String[] asd = valuesString.split(",");
            valuesString = "";
            for (int i = 0; i < asd.length; i++) {
                if(i == 0) {
                    valuesString+=("'"+asd[i]+"'");
                }
                else {
                    valuesString+=(",'"+asd[i]+"'");
                }
            }
            String sql = "INSERT INTO "+ nameOfTable + "("+attibutesString+")"+" VALUES("+valuesString+")";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }
}