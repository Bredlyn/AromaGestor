package com.prueba.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "ventas")
public class Venta {

    @Id
    private String id;

    private Date fecha;

    private ClienteEmb cliente;
    private VendedorEmb vendedor;
    private List<DetalleVentaEmb> detalles;


    @Data
    @NoArgsConstructor
    public static class ClienteEmb {
        private String id;
        private String nombre;
    }

    @Data
    @NoArgsConstructor
    public static class VendedorEmb {
        private String id;
        private String nombre;
    }

    @Data
    @NoArgsConstructor
    public static class DetalleVentaEmb {
        private String productoId;
        private String nombre;
        private int cantidad;
    }
}
