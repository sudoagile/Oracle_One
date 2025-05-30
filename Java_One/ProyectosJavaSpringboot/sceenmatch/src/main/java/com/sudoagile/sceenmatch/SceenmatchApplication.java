package com.sudoagile.sceenmatch;

import com.sudoagile.sceenmatch.model.DatosEpisodio;
import com.sudoagile.sceenmatch.model.DatosSerie;
import com.sudoagile.sceenmatch.model.DatosTemporadas;
import com.sudoagile.sceenmatch.principal.EjemploStreams;
import com.sudoagile.sceenmatch.principal.Principal;
import com.sudoagile.sceenmatch.service.ConsumoAPI;
import com.sudoagile.sceenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SceenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SceenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.muestraElMenu();
        //EjemploStreams ejemploStreams = new EjemploStreams();
        //ejemploStreams.muestraEjemplo();




    }
}