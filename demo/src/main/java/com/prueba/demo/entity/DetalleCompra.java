package com.prueba.demo.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@NoArgsConstructor
@Entity
@Data
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    private Producto producto;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @ManyToOne
    Compra compra;

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
