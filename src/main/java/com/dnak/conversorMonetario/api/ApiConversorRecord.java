package com.dnak.conversorMonetario.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiConversorRecord {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double getTaxa(String moeda) {
        try {
            URL url = new URL(API_URL + moeda.substring(0, 3));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder jsonString = new StringBuilder();

                while (scanner.hasNext()) {
                    jsonString.append(scanner.nextLine());
                }
                scanner.close();

                JsonObject jsonObject = JsonParser.parseString(jsonString.toString()).getAsJsonObject();
                return jsonObject.getAsJsonObject("rates").get(moeda.substring(4)).getAsDouble();
            } else {
                throw new RuntimeException("Erro na requisição: " + responseCode);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao conectar com a API: " + e.getMessage());
        }
    }
}