package com.sudoagile.screenmatch.modelos;

import com.google.gson.Gson;

public class EjemploGson {
    public static void main(String[] args) {
        String json = """
          {
            "nombre" : "Juan",
            "edad" : 30,
            "email" : "juan@email.com"
          }
        """;

        Gson gson = new Gson();
        Persona persona = gson.fromJson(json, Persona.class);
        System.out.println(persona.getEdad());
    }
}
