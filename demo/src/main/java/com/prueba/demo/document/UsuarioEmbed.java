package com.prueba.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioEmbed {

    private String id;
    private String nombre;
    private String rol;
}
