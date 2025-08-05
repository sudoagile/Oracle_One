package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a605f25c";
    private ConvierteDatos conversor = new ConvierteDatos();
    // Cambiamos la lista para que almacene objetos de tipo Serie
    private List<Serie> series = new ArrayList<>();

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar series 
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private DatosSerie getDatosSerie() {
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        return conversor.obtenerDatos(json, DatosSerie.class);
    }

    private void buscarEpisodioPorSerie() {
        // Obtenemos los datos crudos de la serie
        DatosSerie datosSerie = getDatosSerie();
        // Creamos una lista para las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();

        // Iteramos para obtener los datos de cada temporada
        for (int i = 1; i <= datosSerie.totalTemporadas(); i++) {
            var json = consumoApi.obtenerDatos(URL_BASE + datosSerie.titulo().replace(" ", "+") + "&season=" + i + API_KEY);
            DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporada);
        }
        temporadas.forEach(System.out::println);
    }

    private void buscarSerieWeb() {
        // 1. Obtenemos los datos crudos de la API
        DatosSerie datos = getDatosSerie();
        // 2. Convertimos los datos crudos a un objeto Serie (procesado)
        Serie serie = new Serie(datos);
        // 3. Añadimos la serie procesada a nuestra lista
        series.add(serie);
        // 4. Imprimimos el objeto Serie, que tiene el formato que esperas
        System.out.println(serie);
    }

    private void mostrarSeriesBuscadas() {
        // Como la lista ya es de tipo Serie, solo necesitamos ordenarla e imprimirla
        series.stream()
            .sorted(Comparator.comparing(Serie::getGenero))
            .forEach(System.out::println);
    }
}