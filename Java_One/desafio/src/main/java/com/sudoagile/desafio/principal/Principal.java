package com.sudoagile.desafio.principal;

import com.sudoagile.desafio.model.Datos;
import com.sudoagile.desafio.model.DatosLibros;
import com.sudoagile.desafio.service.ConsumoAPI;
import com.sudoagile.desafio.service.ConvierteDatos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Slf4j
@Component
public class Principal implements CommandLineRunner {
    private static final String URL_BASE = "https://gutendex.com/books/";

    private final ConsumoAPI consumoAPI;
    private final ConvierteDatos conversor;

    private Scanner teclado = new Scanner(System.in);

    public Principal(ConsumoAPI consumoAPI, ConvierteDatos conversor) {
        this.consumoAPI = consumoAPI;
        this.conversor = conversor;
    }

    @Override
    public void run(String... args) {
        //try {
        String json = consumoAPI.obtenerDatos(URL_BASE);

        // Imprimir solo el inicio del JSON para simular el formato mostrado
        System.out.println(json.substring(0, Math.min(json.length(), 150)) + "...");

        // Convertir a objeto para obtener los datos
        var datos = conversor.obtenerDatos(json, Datos.class);

        // Logs específicos
       /*     log.info("Datos obtenidos: Número de libros: {}", datos.count());
            log.info("URL de siguiente página: {}", datos.next());
        } catch (Exception e) {
            log.error("Error en la ejecución", e;*/

        System.out.println(datos);

        System.out.println("Top 10 libros más descargados");
        datos.results().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de libros por nombre

        System.out.println("Ingrese el nombre del libro que desea buscar:");
        var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.results().stream().filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro encontrado");
            System.out.println(libroBuscado.get());
        } else {
            System.out.println("Libro no encontrado");
        }

        //Trabajando con estadisticas
        java.util.DoubleSummaryStatistics est = datos.results().stream()
                .filter(d -> d.numeroDescargas() > 0)
                .collect(java.util.stream.Collectors.summarizingDouble(DatosLibros::numeroDescargas));
        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("Cantidad máxima de descargas: " + est.getMax());
        System.out.println("Cantidad mínima de descargas: " + est.getMin());
        System.out.println("Cantidad de registros evaluados para calcular las estadísticas: " + est.getCount());

    }
}