package com.sudoagile.screenmatch.modelos;
import java.util.HashMap;
import java.util.Map;

public class EjemploHashMap {

    public static void main(String[] args) {
        //Creando un objeto de la clase HashMap que implementa la interface Map
        Map<String, Integer> usandoHashMap = new HashMap<>();

        // Agregando pares clave-valor
        usandoHashMap.put("Gatos", 1);
        usandoHashMap.put("Perros", 2);
        usandoHashMap.put("Ratones", 3);

        // Accediendo un valor usando una clave
        int valor = usandoHashMap.get("Perros");
        System.out.println("Valor de la clave Perros: " + valor);

        // Eliminando un par clave-valor
        usandoHashMap.remove("Gatos");
        //usandoHashMap.remove("Ratones");

        // Iterando sobre las claves
        for (String clave : usandoHashMap.keySet()) {
            System.out.println("Clave: " + clave);
            System.out.println("Valor: " + usandoHashMap.get(clave));
        }
    }
}
