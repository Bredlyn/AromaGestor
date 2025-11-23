package com.prueba.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProveedorForm {
    private String nombre;
    private String producto;
    private int cantidadProducto;
}
