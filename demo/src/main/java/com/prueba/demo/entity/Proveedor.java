package com.prueba.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "producto", nullable = false)
    private String producto;
    @Column(name = "cantidadProducto", nullable = false)
    private int cantidadProducto;
}
