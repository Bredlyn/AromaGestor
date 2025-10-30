package com.prueba.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private int cantidad;

    @ManyToOne
    private Proveedor proveedor;

    @ManyToOne
    private Producto producto;
}


