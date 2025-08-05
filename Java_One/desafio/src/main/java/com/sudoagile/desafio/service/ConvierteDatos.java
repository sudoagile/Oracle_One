package com.sudoagile.desafio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.security.jarsigner.JarSignerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConvierteDatos implements IConvierteDatos {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return mapper.readValue(json.toString(), clase);
        } catch (JsonProcessingException e) {
            log.error("Error al convertir JSON", e);
            throw new RuntimeException("No se pudo convertir el JSON", e);
        }
    }
}