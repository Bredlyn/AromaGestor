package com.prueba.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "proveedores")
public class Proveedor {

    @Id
    private String id;

    private String nombre;

    private List<ProductoSuministrado> productosSuministrados;

    @Data
    @NoArgsConstructor
    public static class ProductoSuministrado {
        private String nombre;
        private int cantidadProducto;
    }
}
