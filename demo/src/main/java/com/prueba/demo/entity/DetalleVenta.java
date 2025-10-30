package com.prueba.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    private Producto producto;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    Venta venta;

}
