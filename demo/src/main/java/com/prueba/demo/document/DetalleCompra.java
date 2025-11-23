package com.prueba.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetalleCompra {

    private String productoId;
    private String nombre;
    private int cantidad;
}
