package com.sudoagile.screenmatch.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sudoagile.screenmatch.modelos.Titulo;
import com.sudoagile.screenmatch.modelos.TituloOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.printf("Ingrese el nombre de la pelicula: ");
        var busqueda = sc.nextLine();

        String direccion = "https://www.omdbapi.com/?t=" +busqueda+"&apikey=a605f25c";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        TituloOmdb miTituloOmdb =gson.fromJson(json, TituloOmdb.class);
        System.out.println(miTituloOmdb);
        Titulo miTitulo = new Titulo(miTituloOmdb);
        System.out.println(miTitulo);

    }
}
