package service;

import com.google.gson.Gson;
import model.DeckModel;
import utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeckService {
    static String urlRequest = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
    static int succesCode = 200;

    public static DeckModel pickADeck() throws Exception {
        try {
            URL url = new URL(urlRequest);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection.getResponseCode() != succesCode) {
                throw new RuntimeException("HTTP error code: " + connection.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String json = Utils.convertJson(response);

            Gson gson = new Gson();
            DeckModel deck = gson.fromJson(json, DeckModel.class);

            return deck;
        } catch (Exception e) {
            throw new Exception("Erro: " + e);
        }
    }
}
