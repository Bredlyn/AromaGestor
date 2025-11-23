package com.prueba.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetalleVenta {

    private String productoId;
    private String nombre;
    private int cantidad;
}
