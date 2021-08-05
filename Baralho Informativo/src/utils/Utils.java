package utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Utils {

    public static String convertJson(BufferedReader bufferedReader) throws IOException {
        String response;
        String json = "";
        while ((response = bufferedReader.readLine()) != null) {
            json += response;
        }
        return  json;
    }
}
