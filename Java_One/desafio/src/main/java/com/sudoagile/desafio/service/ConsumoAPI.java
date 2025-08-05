package com.sudoagile.desafio.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumoAPI {
    public String obtenerDatos(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al obtener datos. Código: " + response.statusCode());
            }

            return response.body();
        } catch (Exception e) {
            log.error("Excepción al consumir API", e);
            throw new RuntimeException("No se pudo obtener los datos", e);
        }
    }
}