package com.prueba.demo.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data
@NoArgsConstructor
@Document(collection = "productos")
public class Producto {

    @Id
    private String id;

    private String nombre;

    private int stock;


    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }

    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }
}

