package com.sudoagile.sceenmatch.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
