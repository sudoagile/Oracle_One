package com.sudoagile.casadelcodigo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    private String nombre;
    private Integer añoNacimiento;
    private Integer añoMuerte;
}