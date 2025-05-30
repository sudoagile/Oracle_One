package com.sudoagile.sceenmatch.principal;

import com.sudoagile.sceenmatch.model.DatosEpisodio;
import com.sudoagile.sceenmatch.model.DatosSerie;
import com.sudoagile.sceenmatch.model.DatosTemporadas;
import com.sudoagile.sceenmatch.model.Episodio;
import com.sudoagile.sceenmatch.service.ConsumoAPI;
import com.sudoagile.sceenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;



public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();

    private final String URL_BASE = "http://www.omdbapi.com/?t=";

    private final String API_KEY= "&apikey=a605f25c";
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu() {

        System.out.println("Por favor escribe el nombre de la serie que deseas buscar");
        //Busca los datos generales de las series
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //Busca los datos de todas las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(datos.totalDeTemporadas()); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+")
                    + "&Season=" + i + API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
        //temporadas.forEach(System.out::println);

        //Mostrar solo el titulo de los episodios para las temporadas
        /*for (int i = 0; i < Integer.parseInt(datos.totalDeTemporadas()) ; i++) {
            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {

                System.out.println(episodiosTemporada.get(j).titulo());
            }
        }*/
        // Es lo mismo que arriba:
        /*temporadas.forEach(t ->
                t.episodios().forEach(e -> System.out.println(e.titulo())));*/
        //Convertir todas las informaciones a una lista del tipo DatosEpisodio

        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());


        // Top 5 episodios
     /*   System.out.println("Top 5 episodios de la temporada");
        datosEpisodios.stream()
                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("Primer filtro (N/A)" + e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e -> System.out.println("Segundo filtro Ordenación (M>m)" + e))
                .map(e->e.titulo().toUpperCase())
                .peek(e -> System.out.println("Tercer filto Mayusculas (m>M)" + e))
                .limit(5)

                .forEachOrdered(System.out::println);*/

        //Convirtiendo los datos a una lista del tipo episodio

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        //episodios.forEach(System.out::println);

        //Busqueda de episodios a partir de x año

     /*   System.out.println("Por favor indica el año a partir del cual deseas ver los episodios ");
        var fecha = teclado.nextInt();
        teclado.nextLine();*/

       // LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        /*episodios.stream()
                .filter(e->e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e-> System.out.println(
                       "Temporada "+e.getTemporada()+
                               "Episodio "+ e.getTitulo()+
                               "Fecha de Lanzamiento "+e.getFechaDeLanzamiento().format(dtf)

                ));*/

//Busca episodios por pedaso de titulo

        System.out.println("Por favor escribe el titulo del episodio que desea ver");
        var pedazoTitulo = teclado.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();
        if (episodioBuscado.isPresent()) {
            System.out.println("Episodio encontrado");
            System.out.println("Los datos son: "+ episodioBuscado.get());
        }else{
            System.out.println("Episodio no encontrado");
        }
    }}
