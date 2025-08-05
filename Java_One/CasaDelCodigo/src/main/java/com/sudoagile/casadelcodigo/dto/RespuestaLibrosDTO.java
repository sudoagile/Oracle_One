package com.sudoagile.casadelcodigo.dto;

import com.sudoagile.casadelcodigo.model.Libro;
import lombok.Data;
import java.util.List;

@Data
public class RespuestaLibrosDTO {
    private Integer count;
    private String next;
    private List<Libro> results;
}