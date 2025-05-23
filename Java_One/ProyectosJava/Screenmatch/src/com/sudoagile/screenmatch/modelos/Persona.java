package com.sudoagile.screenmatch.modelos;

public class Persona {
    // Campos que coinciden con las claves del JSON
    private String nombre;
    private int edad; // El tipo debe ser int para coincidir con el JSON
    private String email;

    // Constructor (opcional, pero buena práctica)
    public Persona() {
    }

    // Getters para acceder a los valores de los campos
    public String getNombre() {
        return nombre;
    }

    public int getEdad() { // Tipo de retorno corregido a int
        return edad;   // Devuelve el valor del campo edad
    }

    public String getEmail() {
        return email;
    }

    // Setters (opcionales si Gson va a establecer los campos directamente,
    // pero son una buena práctica para la encapsulación)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString (útil para imprimir el objeto directamente y verificar)
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                '}';
    }
}
