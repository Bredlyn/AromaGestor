package com.prueba.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private int stock;

    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }

    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }
}

