package com.prueba.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "compras")
public class Compra {

    @Id
    private String id;

    private Date fecha;

    private ProveedorEmbed proveedor;

    private UsuarioEmbed usuario;

    private List<DetalleCompra> detalles;
}
