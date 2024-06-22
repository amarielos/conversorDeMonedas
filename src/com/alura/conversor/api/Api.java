package com.alura.conversor.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    String getJsonString(String moneda){
        String direccion= "https://v6.exchangerate-api.com/v6/87b5f5b1de3c5165ce4e0e63/latest/"+moneda;
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    public Cambio getCambios(String monedaInicio){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Moneda moneda = gson.fromJson(this.getJsonString(monedaInicio), Moneda.class);

        Cambio cambio = gson.fromJson(moneda.conversion_rates().toString(), Cambio.class);
        return cambio;
    }



}
